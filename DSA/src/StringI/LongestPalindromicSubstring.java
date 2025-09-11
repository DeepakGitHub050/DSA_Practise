package StringI;

/**
 * Problem Description
 * Given a string A of size N, find and return the longest palindromic substring in A.
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 *
 * Problem Constraints
 * 1 <= N <= 6000
 *
 * Input Format
 * First and only argument is a string A.
 *
 * Output Format
 * Return a string denoting the longest palindromic substring of string A.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String A = "aacaabaaa";
        System.out.println(solve(A));
    }
    static String solve(String str) {
        String s = "";
        int l = str.length();

        for (int i=0; i<l; i++) {
            String S = expand(str, i, i);
            if (S.length() > s.length())
                s = S;
        }
        for (int i=0; i<l-1; i++) {
            String S = expand(str, i, i+1);
            if (S.length() > s.length())
                s = S;
        }
        return s;
    }
    static String expand(String s, int x, int y) {
        while (x>=0 && y<s.length() && s.charAt(x) == s.charAt(y)) {
            x--;
            y++;
        }
        return s.substring(x+1, y);
    }
}
