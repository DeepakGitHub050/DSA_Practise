package PrefixSubArray;

import java.util.Arrays;

/**
 * Given an array A of N integers where the i-th element represent the number of chocolates in the i-th packet.
 *
 * There are B number of students, the task is to distribute chocolate packets following below conditions:
 *
 * 1. Each student gets one packets.
 * 2. The difference between the number of chocolates given to any two students is minimum.
 * Return the minimum difference (that can be achieved) between the student who gets minimum number of chocolates and
 * the student who gets maximum number of chocolates.
 *
 * Note: If you can't give each student 1 packet, return 0.
 */
public class ChocolateDistribution {
    public static void main(String[] args) {
        int[] A = {3, 4, 1, 9, 56, 7, 9, 12};
        int B = 5;
        System.out.println(solve(A, B));
    }
    static int solve(int[] A, int B){
        int N = A.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(A);
        if(N<B)
            return 0;
        else{
            if(B==0)
                min = 0;
            else{
                for(int i=0;i<(N-B-1);i++){
                    if(min>(A[i+B-1]-A[i]))
                        min = A[i+B-1]-A[i];
                }
            }
        }
        return min;
    }
}
