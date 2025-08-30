package Searching1;

/**
 * Problem Description
 * Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.
 *
 * NOTE:
 * A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
 *
 * Problem Constraints
 * 3 <= N <= 105
 * 1 <= A[i], B <= 108
 *
 * Given array always contain a bitonic point.
 * Array A always contain distinct elements.
 *
 * Input Format
 * First argument is an integer array A denoting the bitonic sequence.
 * Second argument is an integer B.
 *
 * Output Format
 * Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.
 */
public class SearchInBitonicArray {
    public static void main(String[] args) {
        int[] A = {3, 9, 10, 20, 17, 5, 1};
        int B = 9;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B) {
        int mid = findPeak(A);
        if (A[mid] == B)
            return  mid;
        if (B > A[mid])
            return -1;
        int ans = search(A, 0, mid, B);
        if (ans == -1) {
            return search(A, mid+1, A.length, B);
        } else
            return ans;
    }
    static int findPeak(int[] arr) {
        int m = arr[0], ind=0;

        for (int i=0; i< arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
                ind = i;
            }
        }
        return ind;
    }
    static int search(int[] A,int l, int r ,int B) {
        int mid;
        while (l<r) {
            mid = (l+r)/2;
            if (A[mid] == B)
                return mid;
            if (A[mid] > B)
                r = mid -1;
            else
                l = mid+1;
        }
        return -1;
    }
}
