package Recursion1;

/**
 * Problem Description
 *
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 *
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
 * Fn = Fn-1 + Fn-2
 * Given a number A, find and return the Ath Fibonacci Number using recursion.
 * Given that F0 = 0 and F1 = 1.
 * Problem Constraints
 *
 * 0 <= A <= 20
 */
public class FindFibonacciII {
    public static void main(String[] args) {
        System.out.println(solve(10));
    }
    static int solve(int A) {
        if ((A==1) || (A==0))
            return 0;
        if (A==2)
            return 1;
        return solve(A-1) + solve(A-2);
    }
}
