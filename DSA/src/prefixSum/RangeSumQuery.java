package prefixSum;

import java.util.Arrays;

/**
 * You are given an integer array A of length N.
 * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
 * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
 * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 *
 * Return an integer array of length M where ith element is the answer for ith query in B.
 */
public class RangeSumQuery {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{0, 3}, {1, 2}};
        System.out.println(Arrays.toString(solve(A, B)));
    }
    static int[] solve(int[] A, int[][] B) {
        int[] ans = new int[B.length];
        int[] prexS = new int[A.length];
        prexS[0] = A[0];
        for (int i=1; i<A.length; i++) {
            prexS[i] = prexS[i-1]+A[i];
        }
        int j=0;
        for (int[] arr:B){
            int l=arr[0], r = arr[1];
            if (l>0) {
                ans[j] = prexS[r] - prexS[l-1];
            } else
                ans[j] = prexS[r];
            j++;
        }
        return ans;
    }
}
