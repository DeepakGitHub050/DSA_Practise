package ArticulationPointsAndBridges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Problem Description
 * Given an undirected graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge between node B[i][0]
 * and node B[i][1].
 * You have to find all the Articulation Points in the graph.
 * A vertex in an undirected connected graph is an articulation point iff removing it (and edges through it) disconnects the graph.
 * For a disconnected undirected graph, an articulation point is a vertex removing which increases number of connected components.
 * Return a one-dimensional array which contains all the Articulation Points .
 * You can return the Articulation points in any order.
 * <p>
 * NOTE:
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 * <p>
 * Problem Constraints
 * 1 <= A, M <= 3×10^5
 * 1 <= B[i][0], B[i][1] <= A
 * <p>
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 * The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 * <p>
 * Output Format
 * Return a one-dimensional array which contains all the Articulation Points .
 */
public class ArticulationPoints {
    static int maxn = 300009;
    static int[] par = new int[maxn];
    static int[] in = new int[maxn];
    static int[] low = new int[maxn];
    static int[] visited = new int[maxn];
    static int ct;
    static TreeSet<Integer> s = new TreeSet<>();
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2},{4, 1},{2, 4},{3, 4},{5, 2},{3, 1}};
        System.out.println(Arrays.toString(solve(A, B)));
    }

    public static void graph() {
        ct = 0;
        s.clear();
        Arrays.fill(visited, 0);
        Arrays.fill(in, 0);
        Arrays.fill(low, 0);
        Arrays.fill(par, 0);
        adj = new ArrayList<>(maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static int[] solve(int A, int[][] B) {
        graph();
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0)
                dfs(i, i);
        }
        int[] ans = new int[s.size()];
        int index = 0;
        while (s != null && !s.isEmpty()) {
            ans[index] = s.pollFirst();
            index++;
        }
        return ans;

    }

    public static void dfs(int u, int root) {
        in[u] = low[u] = ++ct;
        visited[u] = 1;
        int child = 0;
        for (int v : adj.get(u)) {
            if (visited[v] == 0) {
                child++;
                par[v] = u;
                dfs(v, root);
                low[u] = Math.min(low[u], low[v]);
                if (u == root && child > 1)
                    s.add(u);
                else if (u != root && low[v] >= in[u]) s.add(u);
            } else if (par[u] != v) low[u] = Math.min(low[u], in[v]);
        }
    }
}
