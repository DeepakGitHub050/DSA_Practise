package Hashing1;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array A of N integers.
 *
 * Find the count of the subarrays in the array which sums to zero.
 * Since the answer can be very large, return the remainder on dividing the result with 109+7
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 */
public class CountSubarrayZeroSum {
    public static void main(String[] args) {
        int[] A = {1, -1, -2, 2};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        int c =0,s=0;
        int mod = 1000007;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int j : A) {
            s += j;
            if (map.containsKey(s)) {
                c += map.get(s);
                c %= mod;
                map.put(s, map.get(s) + 1);
            } else
                map.put(s, 1);
        }
        return c%mod;
    }
}
