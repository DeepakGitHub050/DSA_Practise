package TwoPointers;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
 * Assume that there will only be one solution.
 *
 * Problem Constraints
 * -10^8 <= B <= 10^8
 * 1 <= N <= 104
 * -10^8 <= A[i] <= 10^8
 *
 * Input Format
 * First argument is an integer array A of size N.
 * Second argument is an integer B denoting the sum you need to get close to.
 *
 * Output Format
 * Return a single integer denoting the sum of three integers which is closest to B.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] A = {-1, 2, 1, -4};
        int B = 1;
        System.out.println(solve(A,B));
    }
    static int solve(int[] A, int B) {
        int n = A.length, ans = -1, diff = 1000000000;
        Arrays.sort(A);
        for (int i=0; i<n; i++) {
            int j = i+1, k = n-1;
            while (j<k) {
                if ((A[i]+A[j]+A[k]-B) < diff) {
                    diff = Math.abs(A[i]+A[j]+A[k]-B);
                    ans = A[i] + A[j] + A[k];
                }
                if ((A[i] + A[j] + A[k]) > B){
                    k--;
                } else
                    j++;
            }
        }
        return ans;
    }
}
