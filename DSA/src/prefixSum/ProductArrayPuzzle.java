package prefixSum;

import java.util.Arrays;

/**
 * Given an array of integers A, find and return the product array of the same size where the ith element of the product
 * array will be equal to the product of all the elements divided by the ith element of the array.
 *
 * Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 * Return the product array.
 */
public class ProductArrayPuzzle {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solve(A)));
    }
    static int[] solve(int[] arr) {
        int N = arr.length;
        int[] pref = new int[N];
        int[] suf = new int[N];
        pref[0] = arr[0];
        suf[N-1] = arr[N-1];

        for (int i=1; i<N; i++) {
            pref[i] = pref[i-1]*arr[i];
        }
        for (int i=N-2; i>=0; i--) {
            suf[i] = suf[i+1]*arr[i];
        }

        arr[0] = suf[1];
        arr[N-1] = pref[N-2];
        for (int i=1; i<N-1; i++) {
            arr[i] = pref[i-1]*suf[i+1];
        }
        return arr;
    }
}
