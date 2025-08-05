package TwoDMatrices1;

/**
 * Given an array A of length N. Also given are integers B and C.
 *
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 */
public class SubarrayWithGivenSumAndLength {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 5, 1};
        int B = 4;
        int C = 6;
        System.out.println(solve(A,B,C));

    }
    static int solve(int[] arr, int x, int y) {
        int n = arr.length;
        int s =0;
        for (int i=0; i<n; i++) {
            s += arr[i];
            if (i>x-1) {
                s -= arr[i-x];
            }
            if (s==y && i>=x-1) {
                return 1;
            }
        }
        return 0;
    }
}
