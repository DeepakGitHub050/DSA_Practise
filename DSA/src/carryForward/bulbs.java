package carryForward;

import java.util.Scanner;

/**
 * A wire connects N light bulbs.
 * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * You can press the same switch multiple times.
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 * Return an integer representing the minimum number of switches required.
 */
public class bulbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr));
    }
    static int solve(int[] arr){
        int c = 0;
        for (int j : arr) {
            if (j == 0 && c % 2 == 0) {
                c++;
            }
            if (j == 1 && c % 2 != 0) {
                c++;
            }
        }
        return c;
    }
}
