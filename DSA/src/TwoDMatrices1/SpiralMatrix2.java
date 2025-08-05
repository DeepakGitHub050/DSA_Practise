package TwoDMatrices1;

import java.util.Arrays;

/**
 * Given an integer matrix A of size NxN. Print the matrix in spiral form starting from A[0][0] in the first row.
 * For example : Given matrix of 2x2
 * 1 2
 * 3 4
 * You should print => 1 2 4 3
 */
public class SpiralMatrix2 {
    public static void main(String[] args) {
        //int[][] A = {{8, 2, 5},{2, 9, 6},{5, 8, 7}};
        //int[][] A = {{8, 2, 5,6},{2, 9, 6,7},{5, 8, 7,8},{9,6,3,5}};
        int[][] A = {{5,2},{6,8}};
        System.out.println(Arrays.toString(solve(A)));
    }
    static int[] solve(int[][] A) {
        int n = A.length;
        int point = 0;
        int[] res = new int[n*n];
        int range = n-1,k=0;
        while (range>=0) {
            int i=point,j=point;
            for (; j<n-1-point; j++) {
                res[k] = A[i][j];
                k++;
            }
            for (; i<n-1-point; i++) {
                res[k] = A[i][j];
                k++;
            }
            for (;j>point;j--){
                res[k] = A[i][j];
                k++;
            }
            for (;i>point;i--) {
                res[k] = A[i][j];
                k++;
            }
            range-=2;
            point++;
            if (point == (n-1-point)) {
                res[k] = A[point][point];
            }
        }
        return res;
    }
}
