package TwoDMatrices1;

import java.util.Arrays;

/**
 * Given an integer A, generate a square matrix filled with elements from 1 to A^2 in spiral order and
 * return the generated square matrix.
 * Return a 2-D matrix which consists of the elements added in spiral order.
 */
public class SpiralOrderMatrixII {
    public static void main(String[] args) {
        int A = 4;
        System.out.println(Arrays.deepToString(solve(A)));
    }
    static int[][] solve(int x) {
        int[][] res = new int[x][x];

        int point = 0;
        int range = x;
        int k=1;

        while (range >= 0) {
            int i=point, j = point;
            for (;j<x-point-1;j++) {
                res[i][j] = k;
                k++;
            }
            for (;i<x-point-1;i++){
                res[i][j] = k;
                k++;
            }
            for (;j>point;j--){
                res[i][j] = k;
                k++;
            }
            for (;i>point;i--){
                res[i][j] = k;
                k++;
            }
            range-=2;
            point++;
            if (range == 1) {
                res[point][point] = k;
            }
        }
        return  res;
    }
}
