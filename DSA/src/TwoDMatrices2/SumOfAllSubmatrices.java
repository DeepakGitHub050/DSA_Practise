package TwoDMatrices2;

/**
 * Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
 * Return an integer denoting the sum of all possible submatrices in the given matrix.
 */
public class SumOfAllSubmatrices {
    public static void main(String[] args) {
        int[][] A = {{1, 2},{3, 4}};
        System.out.println(solve(A));
    }
    static int solve(int[][] A) {
        int n = A.length;
        int s = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // Number of ways to choose from top-left elements
                int topLeft = (i+1)*(j+1);
                // Number of ways to choose from bottom-right elements
                int bottomRight = (n-i)*(n-j);
                s += (topLeft*bottomRight*A[i][j]);
            }
        }
        return s;
    }
}
