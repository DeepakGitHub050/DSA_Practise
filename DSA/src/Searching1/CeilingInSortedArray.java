package Searching1;

/**
 * Problem Description
 *
 * Given a sorted array B of integers of size A, and a integer value C, return the ceiling of C which is present in array B.
 * Problem Constraints
 * 1 <= A <= 10^5,
 * -10^9 <= B[i] <= 10^9,
 * -10^9 <= C <= 10^9
 *
 * Input Format
 * The first argument A is the size of the array.
 * The second argument B is the sorted array.
 * The third argument C is the integer value whose ceil in the array is to be obtained.
 *
 * Output Format
 * A single integer, denoting the ceil of C present in array B. If no ceil is present return -1.
 */
public class CeilingInSortedArray {
    public static void main(String[] args) {
        int[] B = {2, 5, 6, 9, 18};
        int C = 3;
        System.out.println(solve(B, C));
    }
    static int solve(int[] B, int C) {
        int n = B.length;
        int low = 0, high = n - 1;

        // If C is greater than the last element of the array, return -1
        if (C > B[n - 1]) {
            return -1;
        }

        // Binary search to find the ceiling of C
        while (low <= high) {
            int mid = (low + high) / 2;
            if (B[mid] == C) {
                return B[mid];
            } else if (B[mid] < C) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If C is not present in the array, return the element just greater than C
        return B[low];
    }
}
