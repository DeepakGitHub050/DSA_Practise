package Sorting3;

import java.util.Arrays;

/**
 * Problem Description
 *
 * Given an array of integers A, sort the array into a wave-like array and return it.
 * In other words, arrange the elements into a sequence such that
 *
 * a1 >= a2 <= a3 >= a4 <= a5.....
 * NOTE: If multiple answers are possible, return the lexicographically smallest one.
 *
 * Problem Constraints
 *
 * 1 <= len(A) <= 10^6
 * 0 <= A[i] <= 10^6
 * Return an array arranged in the sequence as described.
 */
public class WaveArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solve(A)));
    }
    static int[] solve(int[] A) {
        Arrays.sort(A);
        for (int i=0; i< A.length-1; i+=2) {
            int t = A[i];
            A[i] = A[i+1];
            A[i+1] = t;
        }
        return A;
    }
}
