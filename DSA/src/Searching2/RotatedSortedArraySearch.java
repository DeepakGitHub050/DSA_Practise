package Searching2;

/**
 * Problem Description
 * Given a sorted array of integers A of size N and an integer B,
 * where array A is rotated at some pivot unknown beforehand.
 * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 * Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
 * You can assume that no duplicates exist in the array.
 * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 109
 * All elements in A are Distinct.
 *
 * Input Format
 * The First argument given is the integer array A.
 * The Second argument given is the integer B.
 *
 * Output Format
 * Return index of B in array A, otherwise return -1
 */
public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        int[] A = {4, 5, 6, 7, 0, 1, 2, 3};
        int B = 5;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B) {
        int n=A.length,l=0, r=n-1,mid;
        while (l<=r) {
            mid = (l+r)/2;
            if (A[mid] == B)
                return mid;
            if (A[0] > B){
                if (A[0] > A[mid]){
                    if (A[mid] < B)
                        l = mid+1;
                    else
                        r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (A[0] <= A[mid]){
                    if (A[mid] > B)
                        r = mid - 1;
                    else
                        l = mid + 1;
                } else {
                    r = mid -1;
                }
            }
        }
        return -1;
    }
}
