package TwoDMatrices2;

/**
 * Given a matrix A of size NxM, which is row-wise and column-wise sorted.
 * Find a submatrix such that sum of its elements is maximum and return this sum.
 *
 * Return an integer value which is maximum submatrix sum
 */
public class MaximumSubmatrix {
    public static void main(String[] args) {
        int[][] A = {{-8, 1, 1},{-1, 6, 6},{7, 10, 10}};
        System.out.println(solve(A));
    }
    static int solve(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int[][] pre = new int[r][c];
        int ans = A[r-1][c-1];
        for (int i=r-1; i>=0; i--) {
            for (int j=c-1; j>=0; j--) {
                if (i==r-1 && j==c-1) pre[i][j] = A[i][j];
                else if(i==r-1) pre[i][j] = A[i][j] + pre[i][j+1];
                else if (j==c-1) pre[i][j] = A[i][j] + pre[i+1][j];
                else pre[i][j] = pre[i+1][j] + pre[i][j+1] + A[i][j] - pre[i+1][j+1];
                ans = Math.max(ans,pre[i][j]);
            }
        }
        return ans;
    }
}
