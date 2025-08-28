package Searching1;

/**
 * Problem Description
 * Given an array of integers A, find and return the peak element in it.
 * An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.
 *
 * NOTE:
 * It is guaranteed that the array contains only a single peak element.
 * Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 109
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 * Output Format
 * Return the peak element.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11, 12};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        if (A[0] > A[1])
            return A[0];
        if (A[A.length-2] > A[A.length-1])
            return A[A.length-2];
        int l=0, r=A.length-2,mid,ans=-1;
        while (l<r){
            mid = (r+l)/2;
            if (A[mid+1] < A[mid] && A[mid-1] < A[mid])
                return A[mid];
            if (A[mid+1] > A[mid] && A[mid-1] < A[mid]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return ans;
    }
}
