package TwoDMatrices1;

/**
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring
 * all the numbers less than or equal to B together.
 *
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 * Return the minimum number of swaps.
 */
public class MinimumSwaps {
    public static void main(String[] args) {
        int[] A = {5, 17, 100,9 ,11, 6};
        int B = 8;
        System.out.println(solve(A,B));
    }
    static int solve(int[] arr, int x) {
        int i=0,j=0,c=0;
        int n = arr.length;
        while (j<n) {
            if (arr[j] >= x) {
                i = j;
                j++;
            }
            if (arr[i] >= x && arr[j] < x) {
                c++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
            j++;
        }
        return c;
    }
}
