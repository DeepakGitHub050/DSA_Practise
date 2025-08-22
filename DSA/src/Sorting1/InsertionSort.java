package Sorting1;

import java.util.Arrays;

/**
 * Problem Description
 *
 * Given an array A containing N integers.
 * You need to sort the array and return it.
 * NOTE: Try to use Insertion Sort with Recursion to solve this problem
 *
 * Problem Constraints
 * 1 <= N <= 5000
 * 1 <= A[i] <= 10^3
 *
 * Return the sorted version of A.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] A = {4, 2, 1, 1};
        insertionSortRecursive(A, A.length);
        System.out.println(Arrays.toString(A));
    }
    static void insertionSortRecursive(int[] arr, int n)
    {
        // Base case
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSortRecursive( arr, n-1 );

        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n-1];
        int j = n-2;

        /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
}
