package TwoDMatrices1;

/**
 * Given an matrix A of size NxN, which is row-wise and column-wise sorted. Find if the number B exists in the matrix.
 *
 * Note :
 * 0 represents False and 1 represents True
 */
public class FindInSortedMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 5, 6},{4, 8, 11},{7, 9, 14}};
        int B = 8;
        System.out.println(solve(A, B));
    }
    static int solve(int[][] arr, int x) {
        int c = arr[0].length;

        for (int[] ints : arr) {
            if (ints[c - 1] >= x) {
                int j = c - 1;
                while (j >= 0) {
                    if (ints[j] == x)
                        return 1;
                    j--;
                }
            }
        }
        return 0;
    }
}
