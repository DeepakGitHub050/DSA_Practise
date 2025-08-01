package prefixSum;

/**
 *You are given an array A of integers of size N.
 * Your task is to find the equilibrium index of the given array
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
 * Note:
 *
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium indexes then return the minimum index.
 *
 * Return the equilibrium index of the given array. If no such index is found then return -1.
 */
public class EquilibriumIndexOfAnArray {
    public static void main(String[] args) {
        int[] A = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(solve(A));
    }
    static int solve(int[] arr) {
        int ans =-1;
        int length = arr.length;
        int[] pref = new int[length];
        int[] suf = new int[length];
        pref[0] = arr[0];
        suf[length-1] = arr[length-1];
        for (int i=1; i<length; i++) {
            pref[i] = pref[i-1] + arr[i];
        }
        for (int i=length-2; i>=0; i--){
            suf[i] = suf[i+1] + arr[i];
        }

        for (int i = 1; i<length-1; i++) {
            if(pref[i-1]==suf[i+1]) {
                ans=i;
            }
        }
        return ans;
    }
}
