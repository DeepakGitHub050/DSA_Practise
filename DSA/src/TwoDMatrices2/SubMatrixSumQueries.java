package TwoDMatrices2;

import java.util.Arrays;

/**
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
 *
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 *
 * NOTE:
 *
 * Rows are numbered from top to bottom, and columns are numbered from left to right.
 * The sum may be large, so return the answer mod 109 + 7.
 * Also, select the data type carefully, if you want to store the addition of some elements.
 * Indexing given in B, C, D, and E arrays is 1-based.
 * Top Left 0-based index = (B[i] - 1, C[i] - 1)
 * Bottom Right 0-based index = (D[i] - 1, E[i] - 1)
 *
 * Return an integer array containing the submatrix sum for each query.
 */
public class SubMatrixSumQueries {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int[] B = {1, 2};
        int[] C = {1, 2};
        int[] D = {2, 3};
        int[] E = {2, 3};
        System.out.println(Arrays.toString(solve(A, B, C, D, E)));
    }
    static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int N = A.length;
        int M = A[0].length;
        long[][] mat = new long[N][M];
        long mod = 1000000007;

        for (int i = 0; i < N; i++) {
            mat[i][0] = A[i][0];
            for (int j = 1; j < M; j++)
                mat[i][j] = (mat[i][j - 1] + A[i][j] + mod) % mod;
        }
        for (int j = 0; j < M; j++) {
            for (int i = 1; i < N; i++)
                mat[i][j] = (mat[i - 1][j] + mat[i][j] + mod) % mod;
        }

        int x = B.length;
        int[] res = new int[x];

        for (int i = 0; i < x; i++) {
            int r1 = B[i] - 1, c1 = C[i] - 1, r2 = D[i] - 1, c2 = E[i] - 1;
            long ans = mat[r2][c2];
            if (r1 > 0) {
                ans -= mat[r1 - 1][c2];
                ans = (ans + mod) % mod;
            }
            if (c1 > 0) {
                ans -= mat[r2][c1 - 1];
                ans = (ans + mod) % mod;
            }
            if (r1 > 0 && c1 > 0) {
                ans += mat[r1-1][c1 - 1];
                ans = (ans + mod) % mod;
            }
            res[i] = (int) ans;
        }
        return res;
    }
}
