package Hashing1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given two integer arrays, A and B of size N and M, respectively.
 * Your task is to find all the common elements in both the array.
 *
 * NOTE:
 *
 * Each element in the result should appear as many times as it appears in both arrays.
 * The result can be in any order.
 * Return an integer array denoting the common elements.
 */
public class CommonElements {
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 1, 3};
        int[] B = {2, 3, 1, 2};
        System.out.println(Arrays.toString(solve(A, B)));
    }
    static int[] solve(int[] A, int[] B) {
        int l = Math.min(A.length,B.length);
        int[] res = new int[l];
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (int j : A) {
            mapA.put(j, mapA.get(j) == null ? 1 : mapA.get(j) + 1);
        }
        int k=0;
        for (int i : B) {
            if (mapA.containsKey(i)) {
                res[k] = i;
                mapA.put(i,mapA.get(i) - 1);
                k++;
            }
        }
        return res;
    }
}
