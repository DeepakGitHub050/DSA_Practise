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
        int ans = 0, i, j;
        for (i = 0, j = n - 1; i < n && j >= 0; i++){
            // since this is sorted so we can travel right to left
            while(A[i][j] == 1){
                ans = i;
                j--;
            }
        }
        return ans;
    }
}
