package carryForward;

import java.util.Scanner;

/**
 * Problem Description
 * You have given a string A having Uppercase English letters.
 * You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.
 * Return an long integer denoting the answer.
 */
public class SpecialSubsequencesAG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solve(str));
    }
    public static int solve(String str){
        int ans=0,c=0;
        for (int i=0;i<str.length(); i++) {
            if (str.charAt(i)=='A') {
                c++;
            }
            if (str.charAt(i)=='G') {
                ans = ans + c;
            }
        }
        return ans;
    }
}
