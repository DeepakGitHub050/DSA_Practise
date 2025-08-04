package PrefixSubArray;

/**
 * Imagine a histogram where the bars' heights are given by the array A.
 * Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.
 *
 * Your task is to calculate the total amount of water that can be trapped in these valleys.
 */
public class RainWaterTrapped {
    public static void main(String[] args) {
        int[] A = {5, 4, 1, 4, 3, 2, 7};
        System.out.println(solve(A));
    }
    static int solve(int[] arr) {
        int n = arr.length;
        int[] prefMax = new int[n];
        prefMax[0] = arr[0];
        int[] sufMax = new int[n];
        sufMax[n-1] = arr[n-1];
        int ans = 0;

        for (int i=1; i<n; i++) {
            prefMax[i] = Math.max(prefMax[i-1], arr[i]);
        }
        for (int i=n-2; i>=0; i--) {
            sufMax[i] = Math.max(sufMax[i+1], arr[i]);
        }

        for (int i=0; i<n; i++) {
            ans = ans + (Math.min(prefMax[i], sufMax[i])-arr[i]);
        }
        return ans;
    }
}
