package TwoPointers;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem Description
 * Given an one-dimensional integer array A of size N and an integer B.
 * Count all distinct pairs with difference equal to B.
 * Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
 *
 * Problem Constraints
 * 1 <= N <= 104
 * 0 <= A[i], B <= 105
 *
 * Input Format
 * First argument is an one-dimensional integer array A of size N.
 * Second argument is an integer B.
 *
 * Output Format
 * Return an integer denoting the count of all distinct pairs with difference equal to B.
 */
public class PairswithGivenDifference {
    public static void main(String[] args) {
        int[] A = {8, 12, 16, 4, 0, 20};
        int B = 4;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B) {
        Arrays.sort(A);
        int n=A.length,i=0,j=1;
        HashSet<String> set = new HashSet<>();

        while (j<n) {
            int t = A[j] - A[i];
            if (t == B) {
                String s = A[i]+""+A[j];
                set.add(s);
                i++;
                j++;
            }
            else if (t < B)
                j++;
            else {
                i++;
                if (i==j)
                    j++;
            }
        }
        return set.size();
    }
}
