package Hashing3;

import java.util.HashSet;

/**
 * Problem Description
 * Given a 2D array A of integer points on a 2D plane. Find and return the number of unique points in the array.
 * The ith point in the array is (A[i][0], A[i][1])
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 105
 * -109 <= A[i][0], A[i][1] <= 109
 *
 * Return an integer that is the number of unique points.
 */
public class Unique2DPoints {
    public static void main(String[] args) {
        int[][] A = {{1, 1},{2, 2},{2, 2},{1, 1},{1, 1}};
        System.out.println(solve(A));
    }
    static int solve(int[][] A) {
        int l = A.length;
        HashSet<String> set = new HashSet<>();

        for (int[] i: A) {
            set.add(i[0]+"_"+i[1]);
        }
        return set.size();
    }
}
