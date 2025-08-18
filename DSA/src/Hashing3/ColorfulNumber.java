package Hashing3;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Problem Description
 * Given a number A, find if it is COLORFUL number or not.
 * If number A is a COLORFUL number return 1 else, return 0.
 * What is a COLORFUL Number:
 *
 * A number can be broken into different consecutive sequence of digits.
 * The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
 * This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
 *
 * Problem Constraints
 * 1 <= A <= 2 * 109
 *
 * Return 1 if integer A is COLORFUL else return 0.
 */
public class ColorfulNumber {
    public static void main(String[] args) {
        int A = 3245;
        System.out.println(solve(A));
    }
    static int solve(int A) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while (A>0) {
            arr.add(A%10);
            A = A/10;
        }
        for (int i=0; i<arr.size(); i++) {
            int prod = 1;
            for (int j=i; j<arr.size(); j++) {
                prod *= arr.get(j);
                if (set.contains(prod))
                    return 0;
                else
                    set.add(prod);
            }
        }
        return 1;
    }
}
