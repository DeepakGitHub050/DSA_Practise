package TwoDMatrices1;

/**
 * Given an array A of size N, find the subarray of size B with the least average.
 * Return the index of the first element of the subarray of size B that has least average.
 * Array indexing starts from 0.
 */
public class SubarrayWithLeastAverage {
    public static void main(String[] args) {
        int[] A = {3, 7, 5, 20, -10, 0, 12};
        int B = 2;
        System.out.println(solve(A,B));
    }
    static int solve(int[] arr, int x) {
        int n = arr.length;
        int s = 0;
        int ans = Integer.MAX_VALUE;
        int min = -1;
        for (int i=0; i<n; i++) {
            s += arr[i];
            if (i>=x) {
                s -= arr[i-x];
                if (s<ans) {
                    ans = s;
                    min = i-x+1;
                }
            }
        }
        return min;
    }
}
