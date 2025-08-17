package Hashing2;

import java.util.HashMap;

/**
 * Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special
 * if elements at those indices in the array are equal.
 *
 * Shaggy wants you to find a special pair such that the distance between that pair is minimum.
 * Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 * Return one integer corresponding to the minimum possible distance between a special pair.
 */
public class ShaggyAndDistances {
    public static void main(String[] args) {
        int[] A = {7, 1, 3, 4, 1, 7};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        int ans = A.length;
        int l;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            if (map.containsKey(A[i])) {
                l = i - map.get(A[i]);
                ans = Math.min(l, ans);
            } else {
                map.put(A[i] , map.containsKey(A[i]) ? map.get(A[i])+1 : 1);
            }
        }
        return ans == A.length ? -1 : ans;
    }
}
