package SubArrays;

/**
 * Given an array A of length N, Find the maximum subarray sum out of all possible non-empty subarray.
 * Only argument A is an array of integers.
 */
public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] A = {-2, 2, 34, -1, 16, 23, 12, 41, -7, -32};
        System.out.println(solve(A));
    }

    static int solve(int[] arr) {
        int col = arr.length;
        int S = arr[0];

        for (int i = 0; i < col; i++) {
            for (int j = i; j < col; j++) {
                int s = 0;
                for (int k = i; k <= j; k++) {
                    s += arr[k];
                }
                S = Math.max(S,s);
            }
        }
        return S;
    }
}
