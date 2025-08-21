package Sorting1;

import java.util.Arrays;

/**
 * Problem Description
 *
 * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
 * Note: A linear time complexity is expected and you should avoid use of any library function.
 * Problem Constraints
 *
 * -2×109 <= A[i], B[i] <= 2×109
 * 1 <= |A|, |B| <= 5×104
 *
 * Return a 1-D vector which you got after merging A and B.
 */
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = {4, 7, 9, 21};
        int[] B = {2, 11, 19, 25};
        System.out.println(Arrays.toString(solve(A,B)));
    }
    static int[] solve(int[] A, int[] B) {
        int x = A.length;
        int y = B.length;
        int l = 0;
        int[] res = new int[x+y];
        int i=0,j=0;
        while (i<x && j<y) {
            if (A[i] <= B[j]) {
                res[l] = A[i];
                i++;
            }
            else {
                res[l] = B[j];
                j++;
            }
            l++;
        }
        if (i<x) {
            while (i<x){
                res[l] = A[i];
                i++;
                l++;
            }
        }
        if (j<y) {
            while (j<y){
                res[l] = B[j];
                j++;
                l++;
            }
        }
        return res;
    }
}
