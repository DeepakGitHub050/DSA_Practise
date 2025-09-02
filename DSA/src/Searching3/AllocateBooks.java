package Searching3;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description
 *
 * Given an array of integers A of size N and an integer B.
 * The College library has N books. The ith book has A[i] number of pages.
 * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 *
 * NOTE: Return -1 if a valid assignment is not possible.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i], B <= 105
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 * Output Format
 * Return that minimum possible number.
 */
public class AllocateBooks {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(12, 34, 67, 90));
        int B = 2;
        System.out.println(books(A, B));
    }
    static int books(ArrayList<Integer> A, int B) {
        long high = Long.MAX_VALUE;
        long low = 0;
        long mid, res = 0;
        if (B > A.size())
            return -1;
        long sum = 0;
        for (int pages : A)
            sum += pages;
        while (low <= high) {
            mid = low + ((high - low) >> 1);

            if (isPossible(A, B, mid, sum)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) res;
    }
    static boolean isPossible(ArrayList<Integer> A, int B, long maxPage, long totalPages) {
        if (maxPage < totalPages / B)
            return false;
        int index = 0;
        int n = A.size();
        int i;
        for (i = 0; i < B && index < n; i++) {
            long total = 0;
            while (total < maxPage && index < n) {
                total += A.get(index);
                if (total > maxPage)
                    break;
                index++;
            }
        }
        if (index < n)
            return false;
        return true;
    }
}
