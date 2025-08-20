package Recursion3;

import java.util.Arrays;

/**
 * Problem Description
 *
 * In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and
 * A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
 * You have the following constraints:
 *
 * Only one disk can be moved at a time.
 * A disk is slid off the top of one tower onto another tower.
 * A disk cannot be placed on top of a smaller disk.
 *
 * You have to find the solution to the Tower of Hanoi problem.
 * You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
 * In each row, there should be 3 integers (disk, start, end), where:
 *
 * disk - number of the disk being moved
 * start - number of the tower from which the disk is being moved
 * end - number of the tower to which the disk is being moved
 *
 * Problem Constraints
 *
 * 1 <= A <= 18
 *
 * Return a 2D array with dimensions M x 3 as mentioned above in the description.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int A = 3;
        System.out.println(Arrays.deepToString(solve(A)));
    }
    static int curr;
    static int[][] ans;
    static int[][] solve (int A) {
        curr = 0;
        int m = (1<<A) - 1;
        ans = new int[m][3];
        rec(A,1,3);
        return ans;
    }
    static void rec(int A, int start, int end) {
        if (A == 1) {
            ans[curr++] = new int[]{A, start, end};
            return;
        }
        // move the A-1 disks from start to buffer, using end as a buffer
        // 1 + 2 + 3 = 6, so 6 minus any two tower numbers will always give us the third tower number.
        rec(A-1, start, 6-start-end);
        ans[curr++] = new int[]{A, start, end};
        // move the A-1 disks from buffer to end, using start as a buffer
        rec(A-1, 6-start-end, end);
    }
}
