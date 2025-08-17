package Hashing2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 * If the answer does not exist return an array with a single integer "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
 */
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] A = {0, 2, 3, 2, 1,2};
        int B = 6;
        System.out.println(Arrays.toString(solve(A, B)));
    }
    static int[] solve(int[] A, int B) {
        int[] res = {-1};
        int l = A.length;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int s = 0;
        for (int i = 0; i < l; i++) {
            s += A[i];
            if (s == B) {
                res = Arrays.copyOfRange(A, 0, i + 1);
                break;
            } else if (sumMap.containsKey(s - B)) {
                res = Arrays.copyOfRange(A, sumMap.get(s - B) + 1, i + 1);
                break;
            } else
                sumMap.put(A[i], 1);
        }
        return res;
    }
}
