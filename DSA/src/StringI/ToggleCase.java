package StringI;

/**
 * Problem Description
 * You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
 * You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * A[i] ∈ ['a'-'z', 'A'-'Z']
 *
 * Input Format
 * First and only argument is a character string A.
 *
 * Output Format
 * Return a character string.
 */
public class ToggleCase {
    public static void main(String[] args) {
        String A = "tHiSiSaStRiNg";
        System.out.println(solve(A));
    }
    static String solve(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c:str.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                sb.append((char)(c+32));
            if (c >= 'a' && c <= 'z')
                sb.append((char)(c-32));
        }
        return sb.toString();
    }
}
