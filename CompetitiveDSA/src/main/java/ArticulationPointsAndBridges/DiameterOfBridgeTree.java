package ArticulationPointsAndBridges;

import java.util.*;

/**
 * Problem Description
 * Given a undirected graph with A nodes labelled from 1 to A containing M edges given in a form of 2D-matrix B of size M * 2
 * where there is an edge between node B[i][0] and B[i][1]
 * For the given graph, the edges, which on deletion do not disconnect the graph are compressed into a node and the edges
 * which on deletion disconnect the graph form an edge between these nodes.
 * The resultant structure will be a tree of course!
 * You have to find and return the diameter of this resultant tree.
 * NOTE:
 * Input graph is connected.
 * No multiple edges and self loops are present.
 * Diameter of a tree is defined as the number of edges on the longest path in the tree.
 *
 * Problem Constraints
 * 1 <= A <= 3*10^5
 * A-1 <= M <= 3*105
 *
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 * The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 *
 * Output Format
 * Return a single integer denoting the diameter of the resultant tree.
 */
public class DiameterOfBridgeTree {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {3, 1}};
        System.out.println(solve(A, B));
    }
    // Global variables to track discovery times during DFS
    private static int time;
    private static int[] discoveryTime;
    private static int[] lowerTime;

    /**
     * Main function to compute the diameter of the resultant tree
     * formed by compressing non-bridge edges into nodes.
     *
     * @param A - number of nodes in the graph
     * @param B - 2D array representing undirected edges
     * @return diameter of the resultant tree
     */
    public static int solve(int A, int[][] B) {
        // Step 1: Build adjacency list representation of the graph
        Map<Integer, List<Integer>> graph = generateGraph(B);

        // Step 2: Find all bridges (critical edges)
        Set<String> bridges = findBridges(A, graph);

        // Step 3: Run first DFS to find the farthest node from an arbitrary node (say node 1)
        int[] farthestNode = dfs(1, -1, graph, bridges, new boolean[A + 1]);

        // Step 4: Run second DFS from the farthest node found to get the diameter
        return dfs(farthestNode[0], -1, graph, bridges, new boolean[A + 1])[1];
    }

    /**
     * Depth-First Search (DFS) to traverse through bridge edges
     * and compute the farthest node and distance.
     *
     * @param vertex - current node
     * @param parent - parent node
     * @param graph - adjacency list
     * @param bridges - set of all bridge edges
     * @param visited - boolean array to track visited nodes
     * @return int[]{farthestNode, distance}
     */
    private static int[] dfs(int vertex, int parent, Map<Integer, List<Integer>> graph, Set<String> bridges, boolean[] visited) {
        visited[vertex] = true;
        int[] node = new int[]{vertex, 0}; // stores {farthestNode, distance}

        for (int adjacent : graph.getOrDefault(vertex, new ArrayList<>())) {
            if (adjacent == parent) continue; // skip edge to parent

            if (!visited[adjacent]) {
                int[] adjacentNode = dfs(adjacent, vertex, graph, bridges, visited);

                // Check if this edge is a bridge (critical edge)
                int start = Math.min(vertex, adjacent);
                int end = Math.max(vertex, adjacent);

                // If this is a bridge edge, increase the distance count
                adjacentNode[1] += bridges.contains(start + "-" + end) ? 1 : 0;

                // Update the farthest node and maximum distance
                if (adjacentNode[1] > node[1]) {
                    node[0] = adjacentNode[0];
                    node[1] = adjacentNode[1];
                }
            }
        }
        return node;
    }

    /**
     * Finds all the bridges in the graph using Tarjan’s algorithm.
     *
     * @param A - number of nodes
     * @param graph - adjacency list
     * @return set of strings representing bridges (edges)
     */
    private static Set<String> findBridges(int A, Map<Integer, List<Integer>> graph) {
        time = 0;
        discoveryTime = new int[A + 1];
        lowerTime = new int[A + 1];
        boolean[] visited = new boolean[A + 1];
        Set<String> bridges = new HashSet<>();

        // Run DFS for all unvisited nodes (handles disconnected graphs too)
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                findBridges(i, -1, graph, visited, bridges);
            }
        }
        return bridges;
    }

    /**
     * Helper DFS function to find bridges using discovery and low times.
     *
     * @param vertex - current node
     * @param parent - parent node
     * @param graph - adjacency list
     * @param visited - visited array
     * @param bridges - set to store identified bridges
     */
    private static void findBridges(int vertex, int parent, Map<Integer, List<Integer>> graph, boolean[] visited, Set<String> bridges) {
        visited[vertex] = true;
        discoveryTime[vertex] = time;
        lowerTime[vertex] = time;
        time++;

        for (int adjacent : graph.getOrDefault(vertex, new ArrayList<>())) {
            if (adjacent == parent) continue;

            if (!visited[adjacent]) {
                findBridges(adjacent, vertex, graph, visited, bridges);

                // Update low time of current vertex based on child
                lowerTime[vertex] = Math.min(lowerTime[vertex], lowerTime[adjacent]);

                // If the lowest reachable vertex from adjacent is greater than discovery time of vertex,
                // then (vertex - adjacent) is a bridge
                if (discoveryTime[vertex] < lowerTime[adjacent]) {
                    int start = Math.min(vertex, adjacent);
                    int end = Math.max(vertex, adjacent);
                    bridges.add(start + "-" + end);
                }
            } else {
                // Update low time if adjacent is already visited (back edge)
                lowerTime[vertex] = Math.min(lowerTime[vertex], discoveryTime[adjacent]);
            }
        }
    }

    /**
     * Utility function to build adjacency list representation of graph.
     *
     * @param edges - list of edges
     * @return adjacency list
     */
    private static Map<Integer, List<Integer>> generateGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
