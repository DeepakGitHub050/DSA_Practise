package carryForward;

import java.util.Scanner;

/**
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Return the maximum possible profit.
 * Return an integer, representing the maximum possible profit.
 */
public class BestTimeToBuyAndSellStocksI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr));
    }
    static int solve(int[] arr) {
        int ans =0,j=0;
        for (int i=1; i<arr.length; i++){
            if (arr[i]<arr[j]) {
                j++;
            }
            if (arr[i]>arr[j]){
                ans = Math.max(ans, arr[i] - arr[j]);
            }
        }
        return ans;
    }
}
