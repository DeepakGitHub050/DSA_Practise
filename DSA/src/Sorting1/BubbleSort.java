package Sorting1;

import java.util.Arrays;

/**
 * Problem Description
 *
 * Implement Bubble Sort in the article below.
 * Given an integer array A of size N, sort the array using bubble sort algorithm.
 *
 * Return the array after sorting.
 *
 * Problem Constraints
 *
 * 1 <= N <= 103
 * 1 <= Ai <= 109
 *
 * Return the array A after sorting.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3};
        System.out.println(Arrays.toString(solve(A)));
    }
    static int[] solve(int[] A) {
        int n = A.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (A[j]>A[j+1]) {
                    int t = A[j];
                    A[j] = A[j+1];
                    A[j+1] = t;
                }
            }
        }
        return A;
    }
}
