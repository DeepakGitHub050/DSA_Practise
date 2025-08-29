package Searching1;

/**
 * Problem Description
 *
 * You are given a sorted array A of size N and a target value B.
 * Your task is to find the index (0-based indexing) of the target value in the array.
 *
 * If the target value is present, return its index.
 * If the target value is not found, return the index of least element greater than equal to B.
 * If the target value is not found and least number greater than equal to target is also not present,
 * return the length of array (i.e. the position where target can be placed)
 * Your solution should have a time complexity of O(log(N)).
 *
 * Problem Constraints
 *
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^5
 * 1 <= B <= 10^5
 *
 * Input Format
 * The first argument is an integer array A of size N.
 * The second argument is an integer B.
 *
 * Output Format
 * Return an integer denoting the index of target value.
 */
public class SortedInsertPosition {
    public static void main(String[] args) {
        int[] A = {1, 3, 4, 6, 9};
        int B = 7;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B) {
        int ind=A.length, l=0,r=A.length-1,mid;
        while (l<r) {
            mid = (l+r)/2;
            if (A[mid] == B) {
                ind = mid;
                break;
            }
            if (A[mid] < B)
                l = mid+1;
            if (A[mid] > B) {
                ind = Math.min(ind, mid);
                r = mid - 1;
            }
        }
        return ind;
    }
}
