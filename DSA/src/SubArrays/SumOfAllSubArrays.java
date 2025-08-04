package SubArrays;

/**
 * You are given an integer array A of length N.
 * You have to find the sum of all subarray sums of A.
 * More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
 * A subarray sum denotes the sum of all the elements of that subarray.
 *
 * Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.
 */
public class SumOfAllSubArrays {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        System.out.println(solve(A));
    }
    static long solve(int[] arr){
        int n = arr.length;
        long total = 0;

        for (int i=0; i<n; i++) {
            total += (long)arr[i]*(i+1)*(n-i);
        }
        return total;
    }
}
