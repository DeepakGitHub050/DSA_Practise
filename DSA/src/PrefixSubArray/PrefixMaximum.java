package PrefixSubArray;

import java.util.Arrays;

/**
 * Kamal is a software developer and he's working on a new feature for an e-commerce website.
 * The website has a list of prices for different products, and Kamal needs to find the maximum price of all products up to a given index.
 *
 * He has the list of prices in an array A of length N, and he needs to write a program
 * that will return the maximum price occurring in the subarray from 0 to i for every index i.
 * Kamal needs your help to implement this function.
 */
public class PrefixMaximum {
    public static void main(String[] args) {
        int[] A = {16, 8, 24, 9, 25, 17};
        System.out.println(Arrays.toString(solve(A)));
    }
    static int[] solve(int[] arr) {
        int n = arr.length;
        int m = arr[0];

        for (int i=0; i<n; i++) {
            m = Math.max(arr[i],m);
            arr[i] = m;
        }
        return arr;
    }
}
