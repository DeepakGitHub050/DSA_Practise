package Recursion2;

/**
 * Problem Description
 *
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and
 * replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 * Problem Constraints
 * 1 <= A <= 20
 * 0 <= B < 2^A - 1
 *
 * Return an integer denoting the Bth indexed symbol in row A.
 */
public class KthSymbol {
    public static void main(String[] args) {
        int A = 4, B=3;
        System.out.println(solve(A, B));
    }
    static int solve(int A, int B) {
        if (A==0 || B==0)
            return 0;
        int p = solve(A-1, B/2);
        if (B%2 ==0)
            return p;
        else
            return 1-p;
    }
}
