package Searching3;

import java.util.Arrays;

/**
 * Problem Description
 *
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of
 * the array represents the location of the stall and an integer B which represents the number of cows.
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall.
 * To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that
 * the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 *
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 * Output Format
 * Return the largest minimum distance possible among the cows.
 */
public class AggressiveCows {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length, l =0,ans = 0;
        int h = A[n-1] - A[0];

        while (l <= h) {
            int mid = (l+h)/2;
            if (isPossible(A, B, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid -1;
            }
        }
        return ans;
    }
    static boolean isPossible(int[] A, int B, int m) {
        int n = A.length;
        int c =1;
        int prev = A[0];
        for (int i=1; i<n; i++) {
            if (A[i] - prev >= m) {
                c ++;
                prev = A[i];
            }
            if (c == B)
                return true;
        }
        return false;
    }
}
