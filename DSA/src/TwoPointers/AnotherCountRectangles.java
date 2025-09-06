package TwoPointers;

/**
 * Problem Description
 * Given a sorted array of distinct integers A and an integer B, find and
 * return how many rectangles with distinct configurations can be created using elements of this array as length and
 * breadth whose area is lesser than B.
 * (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
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
 * Return the number of rectangles with distinct configurations with area less than B modulo (10^9 + 7).
 */
public class AnotherCountRectangles {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int B = 3;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B) {
        int n = A.length, count = 0, l = 0, r = n-1;
        while (l < n && r >= 0) {
            int area = A[l]*A[r];
            if (area < B) {
                count += r+1;
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
