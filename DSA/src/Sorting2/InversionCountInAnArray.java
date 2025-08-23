package Sorting2;

/**
 * Problem Description
 *
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
 * Find the total number of inversions of A modulo (10^9 + 7).
 *
 * Problem Constraints
 * 1 <= length of the array <= 10^5
 * 1 <= A[i] <= 10^9
 *
 * Return the number of inversions of A modulo (10^9 + 7).
 */
public class InversionCountInAnArray {
    public static void main(String[] args) {
        int[] A = {3, 4, 1, 2};
        int mod = 1000000007;
        int[] temp = new int[A.length];
        System.out.println(solve(A, temp, 0, A.length-1)%mod);
    }
    static int solve(int[] A, int[] temp, int l, int r) {
        int mid, invc = 0;
        if (l<r) {
            mid = (l+r)/2;
            invc = solve(A, temp, l, mid);
            invc += solve(A, temp, mid+1, r);
            invc += merge(A, temp, l, mid+1, r);
        }
        return invc;
    }
    static int merge(int[] A, int[] temp, int l, int mid, int r) {
        int i=l, j=mid, k=l, invc = 0;
        while (i<mid && j<=r) {
            if (A[i]>A[j]) {
                temp[k++] = A[j++];
                invc += mid-i;
                invc %= 1000000007;
            } else {
                temp[k++] = A[i++];
            }
        }
        while (i<mid){
            temp[k++] = A[i++];
        }
        while (j<r) {
            temp[k++] = A[j++];
        }
        for (i=l; i<=r; i++) {
            A[i] = temp[i];
        }
        return invc;
    }
}
