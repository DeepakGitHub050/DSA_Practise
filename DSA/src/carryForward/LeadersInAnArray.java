package carryForward;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
 * An element is a leader if it is strictly greater than all the elements to its right side.
 * NOTE: The rightmost element is always a leader.
 * Return an integer array denoting all the leader elements of the array.
 */
public class LeadersInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int[] arr = new int[N];
//
//        for (int i=0;i<N; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(solve(arr)));

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(solve(arr));
    }

    static int[] solve(int[] arr) {

        int length = arr.length;
        int[] ans = new int[length];
        int lead=arr[length -1];
        ans[length -1] = arr[length -1];
        for (int i = length-2; i>= 0; i--) {
            if (arr[i]>lead) {
                lead = arr[i];
                ans[i] = lead;
            }
        }
        return ans;
    }
    static ArrayList<Integer> solve(ArrayList<Integer> arr) {

        int length = arr.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int lead=arr.get(length -1);
        ans.add(arr.get(length -1));
        for (int i = length-2; i>= 0; i--) {
            if (arr.get(i)>lead) {
                lead = arr.get(i);
                ans.add(lead);
            }
        }
        return ans;
    }
}
/*
 * we can't use arr.add(i,value) line 55,51 bcz the array size is not that i that's why it will throw array out of bound exception
 */
