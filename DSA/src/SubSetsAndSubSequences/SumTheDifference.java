package SubSetsAndSubSequences;

import java.util.Arrays;

/**
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then,
 * for each subsequence, find the difference between the largest and smallest number in that subsequence.
 * Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 * Return an integer denoting the output.
 */
public class SumTheDifference {
    public static void main(String[] args) {
        int[] A = {3, 5, 10};
        System.out.println(solve(A));
    }
    static int solve(int[] A){
        Arrays.sort(A);
        int n = A.length;
        long MOD =  1000000007;
        // iterate over array and with help of
        // horner's rule calc max_sum and min_sum
        long min_sum = 0, max_sum = 0;
        for (int i = 0; i < n; i++)
        {
            max_sum = 2 * max_sum + A[n - 1 - i];
            max_sum %= MOD;
            min_sum = 2 * min_sum + A[i];
            min_sum %= MOD;
        }
        int res = (int)((max_sum - min_sum + MOD)%MOD);
        return res;
    }
}
