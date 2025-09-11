package StringI;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 105
 *
 * Input Format
 * The first argument is an integer array A.
 *
 * Output Format
 * Return an integer array that is the sorted array A.
 */
public class CountSort {
    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3};
        System.out.println(Arrays.toString(solve(A)));
    }
    static int[] solve(int[] A) {
        int mx = -1;
        for (int value : A) {
            mx = Math.max(mx, value);
        }
        int[] freq = new int[mx + 1];
        for (int value : A) {
            freq[value] += 1;
        }
        int k = 0;
        for(int i = 0 ; i <= mx ; i++){
            for(int j = 0 ; j < freq[i] ; j++){
                A[k] = i;
                k++;
            }
        }
        return A;
    }
}
