package Hashing2;

import java.util.Arrays;

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
        int[] A = {1, 2, 3, 4, 5};
        int B = 45;
        System.out.println(Arrays.toString(solve(A, B)));
    }
    static int[] solve(int[] A, int B) {
        int i=0, j=0;
        int l = A.length;
        int[] res = new int[l];
        while (i<l) {
            int s = 0;
            j=i;
            while (j<l) {
                s += A[j];
                if (s == B) {
                    break;
                }
                j++;
            }
            if (j<l)
                break;
            i++;
        }
        if (i<l) {
            while (i<=j){
                res[i] = A[i];
                i++;
            }
        }
        return res;
    }
}
