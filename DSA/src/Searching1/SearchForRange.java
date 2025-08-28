package Searching1;

import java.util.Arrays;

/**
 * Problem Description
 * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
 * Return an array of size 2, such that
 * First element = Left most index of B in A
 * Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].
 * Note : Note: The time complexity of your algorithm must be O(log n)..
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * 1 <= A[i], B <= 109
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * Output Format
 * Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].
 */

public class SearchForRange {
    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        System.out.println(Arrays.toString(solve(A, B))); // [3, 4]
    }

    static int[] solve(int[] A, int B) {
        int[] res = new int[2];
        res[0] = leftSearch(A, B);
        res[1] = rightSearch(A, B);
        return res;
    }

    static int leftSearch(int[] A, int B) {
        int l = 0, r = A.length - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == B) {
                ans = mid;     // candidate for leftmost
                r = mid - 1;   // keep searching left
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    static int rightSearch(int[] A, int B) {
        int l = 0, r = A.length - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == B) {
                ans = mid;     // candidate for rightmost
                l = mid + 1;   // keep searching right
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
