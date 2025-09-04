package TwoPointers;

/**
 * Problem Description
 * Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).
 * N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.
 * Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 105
 *
 * Input Format
 * Single Argument representing a 1-D array A.
 *
 * Output Format
 * Return single Integer denoting the maximum area you can obtain.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] A = {1, 5, 4, 3};
        System.out.println(maxArea(A));
    }
    static int maxArea(int[] A) {
        int maxArea = 0;
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int area = Math.min(A[left], A[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (A[left] < A[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
