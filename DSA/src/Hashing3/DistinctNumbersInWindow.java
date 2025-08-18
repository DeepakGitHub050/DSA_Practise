package Hashing3;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem Description
 *
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * NOTE: if B > N, return an empty array.
 *
 * Problem Constraints
 *
 * 1 <= N <= 106
 * 1 <= A[i] <= 109
 *
 * Return an integer array.
 */
public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        System.out.println(Arrays.toString(solve(A, B)));
    }
    static int[] solve(int[] A, int B) {
        int l = A.length;
        int[] res = new int[l-B+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<B; i++){
            map.put(A[i], map.containsKey(A[i]) ? map.get(A[i])+1 : 1);
        }
        res[0] = map.size();

        for (int i=B; i<l; i++) {
            if (map.get(A[i-B]) > 1) {
                map.put(A[i-B], map.get(A[i-B]) -1);
            } else
                map.remove(A[i-B]);
            map.put(A[i], map.getOrDefault(A[i],1)+1);
            res[i-B+1] = map.size();
        }
        return res;
    }
}
