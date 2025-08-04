package PrefixSubArray;

import java.util.Arrays;

/**
 * You are given an integer array A of size N. You need to perform Q queries on the given array and
 * return the final array after processing all the queries.
 * <p>
 * Each query is of the form (l, r, c), where l and r are indices (1-based) representing a range in the array A,
 * and c is an integer value.
 * <p>
 * For each query, you are required to add the value c to every element within the range [l, r] (inclusive).
 */
public class RangeSumII {
    public static void main(String[] args) {
        int[] A = {1, 2, 1, 4};
        int[][] B = {{2, 3, 2},{1, 4, 5}, {4, 4, 1}};
        System.out.println(Arrays.toString(solve(A, B)));
    }
    static int[] solve(int[] A, int[][] B){
        int n = A.length;
        int q = B.length;
        int[] pre = new int[n];
        for (int i = 0; i < q; i++) {
            int l = B[i][0], r = B[i][1], c = B[i][2];
            l--;
            r--;
            pre[l] += c;
            if (r != n - 1) {
                pre[r + 1] -= c;
            }
        }
        A[0] += pre[0];
        for (int i = 1; i < n; i++) {
            pre[i] += pre[i - 1];
            A[i] += pre[i];
        }
        return A;
    }
}
