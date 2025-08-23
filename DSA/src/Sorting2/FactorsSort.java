package Sorting2;

import java.util.*;

/**
 * Problem Description
 *
 * You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e.,
 * element having the least number of factors should be the first to be displayed and
 * the number having highest number of factors should be the last one.
 * If 2 elements have same number of factors, then number with less value should come first.
 *
 * Note: You cannot use any extra space
 * Problem Constraints
 *
 * 1 <= N <= 104
 * 1 <= A[i] <= 104
 * Return an array of integers.
 */
public class FactorsSort {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(4);
        A.add(7);
        System.out.println(solve(A));
    }
    static ArrayList<Integer> solve(ArrayList<Integer> A) {
        A.sort((a, b) -> {
            int fa = factors(a);
            int fb = factors(b);

            if (fa < fb) return -1;
            else if (fa > fb) return 1;
            else {
                if (a < b) return -1;
                else if (a > b) return 1;
                else return 0;
            }
        });
        return A;
    }
    static int factors(int a) {
        int c = 0,i=1;
        while (i*i <= a) {
            if (a%i ==0) {
                if (i == a / i)
                    c++;
                else
                    c += 2;
            }
            i++;
        }
        return c;
    }
}
