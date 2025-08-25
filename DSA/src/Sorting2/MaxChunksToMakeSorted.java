package Sorting2;

/**
 * Problem Description
 *
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)],
 * if we split the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them in order of splitting, the result equals the sorted array.
 *
 * What is the most number of chunks we could have made?
 *
 * Problem Constraints
 *
 * 1 <= N <= 100000
 * 0 <= A[i] < N
 * Return the maximum number of chunks that we could have made.
 */
public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 0};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        int c=0, maxIndex=0;
        for (int i = 0; i < A.length; i++) {
            maxIndex = Math.max(maxIndex, A[i]);
            if (maxIndex == i)
                c++;
        }
        return c;
    }
}
