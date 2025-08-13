package Hashing1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array A that represents the participants of various contests,
 * where each integer corresponds to a specific learner, and an array B containing
 * the learners for whom you want to check participation frequency, your task is to find
 * the frequency of each learner from array B in the array A and return a list containing all these frequencies
 */
public class FrequencyOdElement {
    public static void main(String[] args) {
        int[] A = {2, 5, 9, 2, 8};
        int[] B = {3, 2};
        System.out.println(Arrays.toString(solve(A, B)));
    }
    static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<A.length; i++) {
            if (map.containsKey(A[i]))
                map.put(A[i],map.get(A[i])+1);
            else
                map.put(A[i], 1);
        }
        int[] res = new int[B.length];
        for (int i=0; i<B.length; i++) {
            res[i] = map.get(B[i]) == null ? 0 :map.get(B[i]) ;
        }
        return res;
    }
}
