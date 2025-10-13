package StringII;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Problem Description
 * You are given two strings, A and B, of size N and M, respectively.
 * You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
 *
 * Problem Constraints
 * 1 <= N < M <= 105
 *
 * Input Format
 * Given two arguments, A and B of type String.
 *
 * Output Format
 * Return a single integer, i.e., number of permutations of A present in B as a substring.
 */
public class PermutationsOfAinB {
    public static void main(String[] args) {
        String A = "aca";
        String B = "acaa";

        System.out.println(solve(A, B));
    }
    static int solve(String strA, String strB) {
        int count = 0, n = strA.length(), m = strB.length();
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for (int i=0; i<n; i++) {
            freqA[strA.charAt(i) - 'a']++;
        }
        for (int i=0; i<n; i++) {
            freqB[strB.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freqA, freqB))
            count++;

        for (int i=n; i<m; i++) {
            freqB[strB.charAt(i) -'a']++;
            freqB[strB.charAt(i-n) - 'a']--;
            if (Arrays.equals(freqA, freqB))
                count++;
        }
        return count;
    }
}
