package Sorting3;

import java.util.Arrays;

/**
 * Problem Description
 * Given an integer array A, sort the array using QuickSort.
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 109
 *
 * Return the sorted array.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] A = {1, 4, 10, 2, 1, 5};
        System.out.println(Arrays.toString(solve(A)));
    }
    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    static int partition (int[] A, int low, int high){
        // We can select pivot any element like: middle, first, last or random
        int pivot = A[high]; // pivot

        int i = (low - 1); // Index of smaller element

        for (int j = low; j <= high - 1; j++){
            // If current element is smaller than the pivot
            if (A[j] < pivot){
                i++; // increment index of smaller element
                swap(A, i, j);
            }
        }
        swap(A, i + 1, high);
        return (i + 1);
    }
    static void quickSort(int[] A, int low, int high){
        if (low < high){
            int idx = partition(A, low, high);
            quickSort(A, low, idx - 1);
            quickSort(A, idx + 1, high);
        }
    }
    static int[] solve(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }
}
