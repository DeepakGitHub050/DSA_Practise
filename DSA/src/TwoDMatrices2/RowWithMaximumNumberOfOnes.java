package TwoDMatrices2;

/**
 * Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.
 *
 * NOTE:
 *
 * If two rows have the maximum number of 1 then return the row which has a lower index.
 * Rows are numbered from top to bottom and columns are numbered from left to right.
 * Assume 0-based indexing.
 * Assume each row to be sorted by values.
 * Expected time complexity is O(rows + columns).
 *
 * Return the row with the maximum number of 1.
 */
public class RowWithMaximumNumberOfOnes {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 0, 0},{0, 0, 0, 1},{0, 0, 1, 1},{0, 1, 1, 1} };
        System.out.println(solve(A));
    }
    static int solve(int[][] A) {
        int n = A.length;
        int ans = 0;
        int index = 0;
        for (int i=0; i<n; i++) {
            int c =0;
            for (int j=0; j<n; j++) {
                if (A[i][j]==1)
                    c++;
            }
            if (c > ans) {
                ans = Math.max(ans, c);
                index = i;
            }
        }
        return index;
    }
}
