package TwoPointers;

/**
 * Problem Description
 * Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] )
 * such that i != j have sum equal to B.
 * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^9
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 *
 * Output Format
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 */
public class PairsWithGivenSumII {
    public static void main(String[] args) {
        int[] A = {1, 5, 7, 10};
        int B = 8;
        System.out.println(solve(A,B));
    }
    static int solve(int[] A, int B) {
        int i = 0, j = A.length - 1, mod = 1000 * 1000 * 1000 + 7;
        long ans = 0;
        while (i < j) {
            if (A[i] + A[j] == B) {
                int ii = i, jj = j;
                if (A[i] == A[j]) {
                    // equal A[i] and A[j]
                    long cnt = j - i + 1;
                    ans += (cnt * (cnt - 1) / 2) % mod;
                    ans %= mod;
                    break;
                } else {
                    // count number of elements with value A[i]
                    while (A[i] == A[ii]) {
                        ii++;
                    }
                    int cnt1 = ii - i;
                    i = ii;
                    // count number of elements with value A[j]
                    while (A[jj] == A[j]) {
                        jj--;
                    }
                    int cnt2 = j - jj;
                    j = jj;
                    ans += ((long) cnt1 * cnt2) % mod;
                    ans %= mod;
                }
            } else if (A[i] + A[j] > B) {
                j--;
            } else i++;
        }
        return (int) ans;
    }
}
