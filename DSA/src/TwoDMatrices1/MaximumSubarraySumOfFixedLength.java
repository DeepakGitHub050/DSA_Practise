package TwoDMatrices1;

/**
 * Given an array A of length N, Find the maximum subarray sum out of all possible subarray of length B.
 */
public class MaximumSubarraySumOfFixedLength {
    public static void main(String[] args) {
        int[] A = {3, 9, 5, 6, 5, 11};
        int B = 3;
        System.out.println(solve(A,B));
    }
    static long solve(int[] arr, int x) {
        int n = arr.length;
        int s=0, ans=0;
        for (int i=0; i<n; i++) {
            s = s+arr[i];
            if (i>x-1)
                s -= arr[i-x];
            if (i>=x-1)
                ans = Math.max(s,ans);
        }
        return ans;
    }
}
