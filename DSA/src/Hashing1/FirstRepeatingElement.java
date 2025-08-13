package Hashing1;

import java.util.HashMap;

/**
 * Given an integer array A of size N, find the first repeating element in it.
 *
 * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
 *
 * If there is no repeating element, return -1.
 *
 * Return an integer denoting the first repeating element.
 */
public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] A = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<A.length; i++) {
             map.put(A[i],(map.containsKey(A[i]) ? (map.get(A[i])+1): 1));
        }

        for (int i=0; i<A.length; i++) {
            if (map.get(A[i]) >1)
                return A[i];
        }
        return -1;
    }
}
