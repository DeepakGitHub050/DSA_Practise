package Sorting2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Problem Description
 *
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Problem Constraints
 *
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*10^9
 * Return a string representing the largest number.
 */
public class LargestNumber {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9));
        System.out.println(largestNumber(A));
    }
    static String largestNumber(ArrayList<Integer> A) {
        A.sort((a, b) -> (String.valueOf(b) + a).compareTo(a + String.valueOf(b)));
        StringBuilder ans = new StringBuilder();
        for (int x : A) {
            ans.append(x);
        }
        if (ans.charAt(0) == '0')
            return "0";
        return ans.toString();
    }
}
