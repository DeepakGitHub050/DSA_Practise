package TwoDMatrices2;

/**
 * Given a matrix of integers A of size N x M and an integer B.
 *
 * In the given matrix every row and column is sorted in non-decreasing order. Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return (i * 1009 + j)
 * If B is not present return -1.
 *
 * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 * Note 3: Expected time complexity is linear
 * Note 4: Use 1-based indexing
 *
 * Return the position of B and if it is not present in A return -1 instead.
 */
public class SearchInRowAndColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int B = 2;
        System.out.println(solve(A, B));
    }
    static int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int l = 0;
        int r = n*n;
        int mid;
        while (l<=r) {
            mid = (l+r)/2;
            int i = mid/n;
            int j = mid%m;
            if (A[i][j]==B)
                return (i+1)*1009+(j+1);
            if (A[i][j] < B) {
                l = mid+1;
            } else r = mid-1;
        }
        return -1;
    }
}
