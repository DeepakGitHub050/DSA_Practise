package Hashing3;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given an unsorted integer array A of size N.
 * Find the length of the longest set of consecutive elements from array A.
 *
 * Problem Constraints
 * 1 <= N <= 106
 * -106 <= A[i] <= 106
 *
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] A = {100, 4, 200, 1, 3, 2};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        int l = A.length;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:A) {
            if (!map.containsKey(i)) {
                int lcount = 0;
                int rcount = 0;
                if (map.containsKey(i-1))
                    lcount = map.get(i-1);
                if (map.containsKey(i+1))
                    rcount = map.get(i+1);
                map.put(i, lcount+rcount+1);
                if (map.containsKey(i-lcount))
                    map.put(i-lcount, map.get(i));
                if (map.containsKey(i+1))
                    map.put(i+rcount, map.get(i));
                maxLen = Math.max(maxLen, rcount+lcount+1);
            }
        }
        return maxLen;
    }
}
