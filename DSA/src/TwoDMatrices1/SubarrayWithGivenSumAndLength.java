package TwoDMatrices1;

/**
 * Given an array A of length N. Also given are integers B and C.
 *
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 */
public class SubarrayWithGivenSumAndLength {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 5, 1};
        int B = 4;
        int C = 6;
        System.out.println(solve(A,B,C));

    }
    static int solve(int[] arr, int x, int y) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            for (int j=i;j<n; j++){
                int s =0;
                for (int k=i; k<=j;k++){
                    s += arr[k];
                }
                if (s==y && (j-i+1)==x){
                    return 1;
                }
            }
        }
        return 0;
    }
}
