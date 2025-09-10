package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem Description
 * Jerry is excited about an array that Tom gave him. The array A consists of N integers.
 * Tom challenges Jerry to find all such unique triplets a, b, c in A such that a + b = - c.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-decreasing order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * <p>
 * Problem Constraints
 * 0 <= N <= 7000
 * -108 <= A[i] <= 108
 * <p>
 * Input Format
 * Single argument representing a 1-D array A.
 * <p>
 * Output Format
 * Output a 2-D vector where each row represent a unique triplet.
 */
public class ThreeSumZero {
    public static void main(String[] args) {
        Integer[] A = {-1, 0, 1, 2, -1, 4};
        System.out.println(threeSum(new ArrayList<>(Arrays.asList(A))));
    }
    static ArrayList<ArrayList<Integer>> threeSum (ArrayList < Integer > A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        if (A == null)
            return res;

        Collections.sort(A);
        int n = A.size();

        for (int low = 0; low < n - 2; low++) {

            int mid = low + 1;
            int high = n - 1;
            int sum = -A.get(low);

            if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue())
                continue;

            while (mid < high) {

                int num = A.get(mid) + A.get(high);

                if (num == sum) {
                    temp.add(A.get(low));
                    temp.add(A.get(mid));
                    temp.add(A.get(high));
                    res.add(new ArrayList<>(temp));
                    temp.clear();

                    int prev = mid;
                    while (mid <= high && A.get(mid).intValue() == A.get(prev).intValue())
                        mid++;

                } else if (num < sum) {
                    mid++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
