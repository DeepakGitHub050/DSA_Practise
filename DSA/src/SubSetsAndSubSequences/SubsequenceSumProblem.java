package SubSetsAndSubSequences;

/**
 * You are given an array of integers A of N size.
 *
 * You have to find that there is any subsequence exists or not whose sum is equal to B.
 *
 * Note: A subsequence is a sequence that can be derived from the given array by deleting zero or more elements
 * without changing the order of the remaining elements.
 * Return 1 if any subsequence sum is equal to B otherwise return 0.
 */
public class SubsequenceSumProblem {
    public static void main(String[] args) {
        int[] A = {1, 20, 13, 4, 5};
        int B = 18;
        System.out.println(solve(A, B));
    }
    static int subsequenceSum(int[] A, int B, int i) {
        if (i == -1) {
            if (B == 0) return 1;
            else return 0;
        }
        int ans = 0;
        ans |= subsequenceSum(A, B, i - 1);
        ans |= subsequenceSum(A, B - A[i], i - 1);
        return ans;
    }
    static int solve(int[] A, int B) {
        if (B == 0) return 0;
        int n = A.length;
        return subsequenceSum(A, B, n - 1);
    }
}
