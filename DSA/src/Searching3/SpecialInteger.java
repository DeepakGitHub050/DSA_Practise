package Searching3;

/**
 * Problem Description
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
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
 * Return the maximum value of K (sub array length).
 */
public class SpecialInteger {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 10;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B) {
        int n = A.length;
        int[] pref = new int[n];
        calculatePref(A, pref);
        int l = 1, h = n, ans = 0;

        while (l<=h){
            int mid = (l+h)/2;
            if (check(mid, pref, B) == 1) {
                h = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
    static void calculatePref(int[] A, int[] pref) {
        pref[0] = A[0];
        for (int i=1; i<A.length; i++) {
            pref[i] = pref[i-1] + A[i];
        }
    }
    static int check(int s, int[] pref, int B) {
        for (int i=s-1; i<pref.length; i++) {
            if (i == s-1){
                if (pref[i] > B)
                    return 1;
            } else if (pref[i] - pref[i-s] > B){
                return 1;
            }
        }
        return 0;
    }
}
