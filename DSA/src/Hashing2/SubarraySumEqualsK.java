package Hashing2;

import java.util.HashMap;

/**
 * Given an array of integers A and an integer B.
 * Find the total number of subarrays having sum equals to B.
 *
 * Problem Constraints
 *
 *  1 <= length of the array <= 50000
 * -1000 <= A[i] <= 1000
 *
 * Return the total number of subarrays having sum equals to B.
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] A = {1, 0, 1};
        int B = 1;
        System.out.println(solve(A,B));
    }
    static int solve(int[] A, int B) {
        int c =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int s=0;
        for (int i=0; i< A.length; i++) {
            s += A[i];
            if (map.containsKey(s-B)) {
                c += map.get(s-B);
            } else {
                map.put(s, map.getOrDefault(A[i],1)+1);
            }
        }
        return c;
    }
}
