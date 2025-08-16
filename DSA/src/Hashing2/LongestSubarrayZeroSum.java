package Hashing2;

import java.util.HashMap;

/**
 * Given an array A of N integers.
 * Find the length of the longest subarray in the array which sums to zero.
 *
 * If there is no subarray which sums to zero then return 0.
 * Problem Constraints
 *
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 */
public class LongestSubarrayZeroSum {
    public static void main(String[] args) {
        int[] A = {1, -5, 1, 2, 1,3,4,5};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        int l =-1,s=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i=0; i<A.length; i++){
            s += A[i];
            if (map.containsKey(s)) {
                l = Math.max(l,i-map.get(s));
            } else
                map.put(s,i);
        }
        return l;
    }
}
