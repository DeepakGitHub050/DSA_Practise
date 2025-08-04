package PrefixSubArray;

import java.util.Arrays;

/**
 * There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
 * When the devotees come to the temple, they donate some amount of coins to these beggars.
 * Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
 *
 * Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A,
 * find out the final amount of money in each beggar's pot at the end of the day,
 * provided they don't fill their pots by any other means.
 * For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
 */
public class ContinousSumQuery {
    public static void main(String[] args) {
        int noBeggars = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.println(Arrays.toString(solve(noBeggars, B)));
    }
    static int[] solve(int beg, int[][] arr) {
        int n = arr.length;
        int[] res = new int[beg];

        for (int[] ints : arr) {
            int l = ints[0];
            res[l - 1] = res[l - 1] + ints[2];
            int r = ints[1];
            if (r <= n)
                res[r] = res[r] - ints[2];
        }

        for (int i=1; i<beg; i++) {
            res[i] = res[i-1] + res[i];
        }
        return res;
    }
}
