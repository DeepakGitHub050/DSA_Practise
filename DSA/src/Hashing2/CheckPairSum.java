package Hashing2;

import java.util.HashSet;

/**
 * Given an Array of integers B, and a target sum A.
 * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
 *
 * Problem Constraints
 * 1 <= Length of array B <= 105
 * 0 <= Bi <= 109
 *
 * Return an integer value 1 if there exists such pair, else return 0.
 */
public class CheckPairSum {
    public static void main(String[] args) {
        int A = 8;
        int[] B = {3, 5, 1, 2, 1, 2};
        System.out.println(solve(A, B));
    }
    static int solve(int A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : B) {
            if (set.contains(A-i))
                return 1;
            else
                set.add(i);
        }
        return 0;
    }
}
