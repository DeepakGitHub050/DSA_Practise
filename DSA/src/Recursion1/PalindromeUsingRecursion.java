package Recursion1;

/**
 * Problem Description
 *
 * Write a recursive function that checks whether string A is a palindrome or Not.
 * Return 1 if the string A is a palindrome, else return 0.
 *
 * Note: A palindrome is a string that's the same when read forward and backward.
 * Problem Constraints
 * 1 <= |A| <= 50000
 * String A consists only of lowercase letters.
 * Return 1 if the string A is a palindrome, else return 0.
 */
public record PalindromeUsingRecursion() {
    public static void main(String[] args) {
        String str = "madam";
        System.out.println(solve(str, 0, str.length()-1));
    }
    static int solve(String str, int a, int b) {
        if (a>=b)
            return 1;
        if (str.charAt(a)==str.charAt(b))
            return solve(str, ++a, --b);
        else
            return 0;
    }
}
