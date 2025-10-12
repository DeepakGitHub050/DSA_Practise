package StringII;

import java.util.HashSet;

/**
 * Problem Description
 * Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters.
 * The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
 * Your task is to return an integer representing the "GOOD"ness of string A.
 * Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.
 *
 * Problem Constraints
 * 1 <= size(A) <= 10^6
 * String consists of lowerCase,upperCase characters and digits are also present in the string A.
 *
 * Input Format
 * Single Argument representing string A.
 *
 * Output Format
 * Return an integer denoting the maximum possible length of substring without repeating characters.
 */
public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String A = "abcabcbb";
        System.out.println(solve(A));
    }
    static int solve(String str) {
        HashSet<Character> characters = new HashSet<>();
        int ans = 0, p=0, q=0;
        while (q < str.length()) {
            char c = str.charAt(q);
            if (characters.contains(c)) {
                ans = Math.max(ans, characters.size());
                characters.remove(str.charAt(p));
                p++;
            } else {
                characters.add(c);
                q++;
            }
        }
        return Math.max(ans, characters.size());
    }
}
