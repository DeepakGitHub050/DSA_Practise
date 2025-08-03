package SubArrays;

import java.util.Arrays;

/**
 * You are given an array A of N integers.
 * Return a 2D array consisting of all the subarrays of the array
 *
 * Note : The order of the subarrays in the resulting 2D array does not matter.
 */
public class GenerateAllSubarrays {
    public static void main(String[] args) {
        int[] A = {5, 2, 1, 4};
        System.out.println((Arrays.deepToString(sove(A))));
    }
    static int[][] sove(int[] arr){
        int col = arr.length;
        int row = col*(col+1)/2;
        int r = 0;
        int[][] res = new int[row][col];

        for (int i=0; i<col; i++) {
            for (int j=i; j<col; j++) {
                int x =0;
                for (int k=i; k<=j; k++) {
                    res[r][x] = arr[k];
                    x++;
                }
                r++;
            }
        }
        return res;
    }
}
