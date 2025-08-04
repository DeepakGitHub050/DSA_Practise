package SubArrays;

/**
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 */
public class GoodSubArraysEasy {
    public static void main(String[] args) {
        int[] A = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int B = 65;
        System.out.println(solve(A,B));

    }
    static int solve(int[] arr, int x) {
        int n = arr.length;
        int c = 0;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int s = 0;
                for (int k=i; k<=j; k++) {
                    s+=arr[k];
                }
                if ((j-i+1)%2==0 && s<x)
                    c++;
                if ((j-i+1)%2!=0 && s>x)
                    c++;
            }
        }
        return c;
    }
}
