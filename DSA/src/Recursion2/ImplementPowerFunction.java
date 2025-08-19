package Recursion2;

/**
 * Problem Description
 *
 * Implement pow(A, B) % C.
 * In other words, given A, B and C, Find (A^B % C).
 * Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
 *
 * Problem Constraints
 *
 * -109 <= A <= 109
 * 0 <= B <= 109
 * 1 <= C <= 109
 *
 * Return an integer.
 */
public class ImplementPowerFunction {
    public static void main(String[] args) {
        int A = 3, B = 3, C = 4;
        System.out.println(solve(A, B) %C);
    }
    static int solve(int A, int B) {
        if (B == 1)
            return A;
        if (B==0)
            return 1;
        return A * solve(A, --B);
    }
}
