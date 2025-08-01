package prefixSum;

import java.util.Arrays;

/**
 * You are given an array A of length N and Q queries given by the 2D array B of size Q*2.
 * Each query consists of two integers B[i][0] and B[i][1].
 * For every query, the task is to calculate the sum of all even indices in the range A[B[i][0]…B[i][1]].
 *
 * Note : Use 0-based indexing
 * Return an array of integers.
 */
public class SumOfEvenIndices {
    public static void main(String[] args) {
        int[] A = {2, 1, 8, 3, 9};
        int[][] B = {{0,3},{2,4}};

        System.out.println(Arrays.toString(solve(A, B)));
    }
    static int[] solve(int[] A, int[][] B) {
        int N = A.length;
        int Q = B.length;
        int[] res = new int[Q];
        int[] pref = new int[N];
        pref[0] = A[0];

        for (int i=1; i<N; i++) {
            if (i%2==0) {
                pref[i] = pref[i-1] + A[i];
            } else {
                pref[i] = pref[i-1];
            }
        }

        for (int i=0; i< Q; i++) {
            int l = B[i][0];
            int r = B[i][1];
            if (l==0) {
                res[i] = pref[r];
            } else
                res[i] = pref[r] - pref[l-1];
        }
        return res;
    }
}
