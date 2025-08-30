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
        int B = 17;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B) {
        int mid = findPeak(A, 0, A.length-1);
        if (A[mid] == B)
            return  mid;
        if (B > A[mid])
            return -1;
        int ans = lsearch(A, 0, mid, B);
        if (ans == -1) {
            return rsearch(A, mid+1, A.length-1, B);
        } else
            return ans;
    }
    static int findPeak(int[] arr, int l, int r) {
        int m = (l+r)/2;
        if (arr[m] > arr[m-1] && arr[m] > arr[m+1])
            return m;
        else if (arr[m] > arr[m - 1] && arr[m] < arr[m + 1])
            return findPeak(arr, m, r);
        else if (arr[m] < arr[m-1] && arr[m] > arr[m+1])
            return findPeak(arr, l, m);
        return -1;
    }
    static int lsearch(int[] A,int l, int r ,int B) {
        int mid;
        while (l<=r) {
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
    static int rsearch(int[] A,int l, int r ,int B) {
        int mid;
        while (l<=r) {
            mid = (l+r)/2;
            if (A[mid] == B)
                return mid;
            if (A[mid] < B)
                r = mid -1;
            else
                l = mid+1;
        }
        return -1;
    }
}
