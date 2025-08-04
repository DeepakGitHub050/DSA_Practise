package PrefixSubArray;

/**
 * Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
 *
 * In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.
 */
public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solve(A));
    }
    static int solve(int[] arr) {
        int n = arr.length;
        int s =0,ans =0;

        for (int j : arr) {
            if (s < 0) {
                s = 0;
            }
            s = s + j;
            ans = Math.max(s, ans);
        }
        return ans;
    }
}
