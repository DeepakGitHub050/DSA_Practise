package Sorting1;

import java.util.Arrays;

/**
 * Problem Description
 * Given an integer array A, sort the array using Merge Sort.
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 109
 *
 * Return the sorted array.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] A = {1, 4, 10, 2, 1, 5};
        System.out.println(Arrays.toString(solve(A)));
    }
    static int[] solve(int[] A) {
        if (A==null || A.length<2)
            return new int[]{};
        sort(A, 0, A.length-1);
        return A;
    }
    static void sort(int[] A, int s, int e) {
        if (s>=e)
            return;
        int mid = s+(e-s)/2;
        sort(A, s, mid);
        sort(A,mid+1,e);
        merge(A, s, mid, e);
    }
    static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }
}
