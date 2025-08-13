package Hashing1;

import java.util.HashSet;

/**
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 * Return whether the given array contains a subarray with a sum equal to 0.
 */
public class SubArrayWith0Sum {
    public static void main(String[] args) {
        int[] A = {1, 2, -3, 4, 5};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int s =0;
        for (int i=0; i<A.length; i++) {
            s = s+A[i];
            if (set.contains(s) || A[i]==0 || s==0)
                return 1;
            set.add(s);
        }
        return 0;
    }
}
