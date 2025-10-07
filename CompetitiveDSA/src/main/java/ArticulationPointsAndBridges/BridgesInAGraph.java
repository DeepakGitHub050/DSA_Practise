package ArticulationPointsAndBridges;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * Given an undirected graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge between node B[i][0]
 * and node B[i][1].
 * You have to find all the bridges in the graph.
 * An edge in an undirected connected graph is a bridge if removing it disconnects the graph. For a disconnected undirected graph, the definition is similar,
 * a bridge is an edge removing which increases the number of disconnected components.
 * Return a two-dimensional arrays which contains all the edges that are bridges.
 * You can return the bridges in any order but for nodes in a bridge order them in ascending order.
 * For example:
 * If there are 3 bridges in the graph having 7 nodes, (2, 1), (5, 3), (1, 7) Then you can return any one of the following array of array integers:
 * [ [1, 2], [3, 5], [1, 7] ]
 * [ [1, 2], [1, 7], [3, 5] ]
 * [ [3, 5], [1, 2], [1, 7] ]
 * [ [3, 5], [1, 7], [1, 2] ]
 * [ [1, 7], [1, 2], [3, 5] ]
 * [ [1, 7], [3, 5], [1, 2] ]
 * NOTE:
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 *
 * Problem Constraints
 * 1 <= A <= 10^5
 * 1 <= B[i][0], B[i][1] <= A
 *
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 *
 * Output Format
 * Return the two-dimensional integer array C where C[i][0] and C[i][1] represents a bridge make sure that C[i][0]<=C[i][1].
 */

// Program to find all the bridges in an undirected graph using DFS (Tarjan’s Algorithm)
public class BridgesInAGraph {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {3, 1}
        };

        // Print the list of bridges
        System.out.println(Arrays.deepToString(solve(A, B)));
    }

    // Maximum possible number of nodes
    static int maxn = 100009;

    // Arrays to store DFS traversal info
    static int[] par = new int[maxn];   // Parent of each node in DFS tree
    static int[] in = new int[maxn];    // Discovery time of each node
    static int[] low = new int[maxn];   // Lowest discovery time reachable from a node
    static int[] visited = new int[maxn]; // Visited flag for each node

    static int ct; // Global timer for DFS discovery time
    static ArrayList<pair> edges; // Stores all bridges
    static ArrayList<ArrayList<Integer>> adj; // Adjacency list representation of the graph

    /**
     * Initializes the graph data structures.
     * This method resets all static variables and prepares adjacency list.
     */
    public static void graph() {
        ct = 0;
        edges = new ArrayList<>();

        Arrays.fill(visited, 0);
        Arrays.fill(in, 0);
        Arrays.fill(low, 0);
        Arrays.fill(par, 0);

        adj = new ArrayList<>(maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList<>());
        }
    }

    /**
     * Main function to find bridges in a graph.
     * @param A - Number of nodes
     * @param B - 2D array of edges
     * @return 2D array of bridge edges
     */
    public static int[][] solve(int A, int[][] B) {
        graph(); // Initialize graph structures

        // Build adjacency list
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Run DFS for each unvisited node
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        // Prepare output array for all bridges
        int[][] ans = new int[edges.size()][2];
        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).a;
            int b = edges.get(i).b;

            // Ensure smaller node comes first in output
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            ans[i][0] = a;
            ans[i][1] = b;
        }

        return ans;
    }

    /**
     * Depth First Search (DFS) to identify bridges using Tarjan’s Algorithm.
     * @param u - Current node
     */
    public static void dfs(int u) {
        // Set discovery and low time
        in[u] = low[u] = ++ct;
        visited[u] = 1;

        // Traverse all adjacent vertices
        for (int v : adj.get(u)) {

            // Case 1: If 'v' is not visited yet (Tree Edge)
            if (visited[v] == 0) {
                par[v] = u;
                dfs(v);

                // Update the low-link value
                low[u] = Math.min(low[u], low[v]);

                // Bridge condition: if lowest reachable vertex from v is above u in DFS tree
                if (low[v] > in[u]) {
                    edges.add(new pair(u, v));
                }
            }

            // Case 2: If 'v' is visited and is not parent (Back Edge)
            else if (par[u] != v) {
                low[u] = Math.min(low[u], in[v]);
            }
        }
    }

    /**
     * Simple Pair class to store an edge (u, v).
     */
    static class pair {
        int a, b;
        public pair(int c, int d) {
            this.a = c;
            this.b = d;
        }
    }
}

