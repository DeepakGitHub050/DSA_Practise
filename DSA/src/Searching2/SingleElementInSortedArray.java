package Searching2;

/**
 * Problem Description
 * Given a sorted array of integers A where every element appears twice except for one element which appears once,
 * find and return this single element that appears only once.
 * Elements which are appearing twice are adjacent to each other.
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 * Output Format
 * Return the single element that appears only once.
 */
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] A = {1, 1, 7};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        int ans=A[0];
        for (int i=1; i<A.length; i++) {
            ans = ans^A[i];
        }
        return ans;
    }
}
