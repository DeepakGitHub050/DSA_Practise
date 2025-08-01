package carryForward;

import java.util.Scanner;

/**
 * You are given an integer array A of size N.
 * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
 * Find and return the maximum possible sum of the B elements that were removed after the B operations.
 * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
 * Remove 3 elements from front and 0 elements from the back, OR
 * Remove 2 elements from front and 1 element from the back, OR
 * Remove 1 element from front and 2 elements from the back, OR
 * Remove 0 elements from front and 3 elements from the back.
 *
 * Return an integer denoting the maximum possible sum of elements you removed.
 */
public class PickFromBothSides {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i< N; i++) {
            arr[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(solve(arr, B));
    }
    static int solve(int[] arr, int B) {
        int ans = 0;
        int s = 0, n = arr.length;
        for(int i=0; i< B; i++){
            s+=arr[i];
        }
        ans = s;
        for(int i=--B; i >=0; i--){
            s-= arr[i];
            s+=arr[n-B+i-1];
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
