package Sorting2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem Description
 *
 * You are developing a feature for Zomato that helps users find the nearest restaurants to their current location.
 * It uses GPS to determine the user's location and has access to a database of restaurants,
 * each with its own set of coordinates in a two-dimensional space representing their geographical location on a map.
 * The goal is to identify the "B" closest restaurants to the user, providing a quick and convenient way to choose where to eat.
 *
 * Given a list of restaurant locations, denoted by A (each represented by its x and y coordinates on a map),
 * and an integer B representing the number of closest restaurants to the user. The user's current location is assumed to be at the origin (0, 0).
 *
 * Here, the distance between two points on a plane is the Euclidean distance.
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
 * NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).
 * Problem Constraints
 *
 * 1 <= B <= length of the list A <= 10^5
 * -10^5 <= A[i][0] <= 10^5
 * -10^5 <= A[i][1] <= 10^5
 * Return the B closest points to the origin (0, 0) in any order.
 */
public class BClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] A = {{1, -1},{2, -1},{3, 3},{-2, 4}};
        int B = 3;
        System.out.println(Arrays.deepToString(solve(A,B)));
    }
    static int[][] solve(int[][] A, int B) {
        int[][] res = new int[B][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q) -> q[0]*q[0] - q[1]*q[1] - p[0]*p[0] - p[1]*p[1]);
        for(int[] i : A) {
            pq.offer(i);
            if (pq.size() > B)
                pq.poll();
        }
        while (B>0){
            res[--B] = pq.poll();
        }
        return res;
    }
}
