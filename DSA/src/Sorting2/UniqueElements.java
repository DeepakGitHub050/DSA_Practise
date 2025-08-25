package Sorting2;

import java.util.Arrays;

/**
 * Problem Description
 *
 * You are given an array A of N elements. You have to make all elements unique.
 * To do so, in one step you can increase any number by one.
 *
 * Find the minimum number of steps.
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 * Return the minimum number of steps required to make all elements unique.
 */
public class UniqueElements {
    public static void main(String[] args) {
        int[] A = {2, 4, 5, 4, 2, 3};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        Arrays.sort(A);
        int c = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i-1]) {
                c += A[i-1] - A[i] + 1;
                A[i] = A[i-1] + 1;
            }
        }
        return c;
    }
}
