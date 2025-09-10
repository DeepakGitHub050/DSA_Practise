package TwoPointers;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will represent the colors as,
 * red -> 0
 * white -> 1
 * blue -> 2
 * Note: Using the library sort function is not allowed.
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 0 <= A[i] <= 2
 *
 * Input Format
 * First and only argument of input contains an integer array A.
 *
 * Output Format
 * Return an integer array in asked order
 */
public class SortByColor {
    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sortColors(A)));
    }
    static int[] sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = A.length - 1;

        while (white <= blue) {
            if (A[white] == 0) {
                int temp = A[red];
                A[red] = A[white];
                A[white] = temp;
                red++;
                white++;
            } else if (A[white] == 1) {
                white++;
            } else {
                int temp = A[red];
                A[red] = A[white];
                A[white] = temp;
                blue--;
            }
        }
        Arrays.sort(A);
        return A;
    }
}
