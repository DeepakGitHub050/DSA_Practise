package Searching3;

/**
 * Problem Description
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
 *
 * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
 * Return the ans % 10000003.
 *
 * Problem Constraints
 * 1 <= A <= 1000
 * 1 <= B <= 10^6
 * 1 <= N <= 10^5
 * 1 <= C[i] <= 10^6
 *
 * Input Format
 *
 * The first argument given is the integer A.
 * The second argument given is the integer B.
 * The third argument given is the integer array C.
 *
 * Output Format
 * Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
 */
public class PaintersPartitionProblem {
    public static void main(String[] args) {
        int A = 10;
        int B = 1;
        int[] C = {1, 8, 11, 3};
        System.out.println(solve(A,B,C));
    }
    static int solve(int A, int B, int[] C) {
        long maxEle = 0,s=0,ans=0;
        long mod = 10000003;
        for(int i:C){
            s=s+i;
            maxEle = Math.max(maxEle, i);
        }

        long minTime = maxEle*B;
        long maxTime = s*B;
        long count = 0;
        long mid = (minTime+maxTime)/2;
        while(minTime<=maxTime){
            count = countPainter(C,B,mid);
            if(count>A){
                minTime = mid+1;
            }
            if(count<A){
                maxTime = mid-1;
            }
            if(count==A){
                ans=mid;
                maxTime = mid-1;
            }
            mid = (minTime+maxTime)/2;
        }
        if(count<A)
            return (int)((mid+1)%mod);
        else
            return (int)(ans%mod);
    }
    static long countPainter(int[] C, long B, long t) {
        long timeLeft=t,p=1;
        for (int i: C){
            if(i*B > t)
                return -1;
            if (i*B <= timeLeft){
                timeLeft = timeLeft - i*B;
            } else {
                p++;
                timeLeft = t - i*B;
            }
        }
        return p;
    }
}
