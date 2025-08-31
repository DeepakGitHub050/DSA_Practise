package Searching2;

/**
 * Problem Description
 * You are given three positive integers, A, B, and C.
 * Any positive integer is magical if divisible by either B or C.
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 10^9 + 7.
 * Note: Ensure to prevent integer overflow while calculating.
 *
 * Problem Constraints
 * 1 <= A <= 10^9
 * 2 <= B, C <= 40000
 *
 * Input Format
 * The first argument given is an integer A.
 * The second argument given is an integer B.
 * The third argument given is an integer C.
 *
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 */
public class AthMagicalNumber {
    public static void main(String[] args) {
        int A = 4, B = 2, C = 3;
        System.out.println(solve(A,B,C));
    }
    static int solve(int A, int B, int C){
        int lcm = A*B/gcd(A,B),ans=0;
        int l = 2, r = A*Math.min(B,C),mid;
        while (l<=r) {
            mid = (l+r)/2;
            int cntB = mid/B, cntC = mid/C, cntBC = mid/lcm;
            if (cntB+cntC-cntBC >= A){
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }
    static int gcd(int x, int y) {
        if (x==0)
            return y;
        return (gcd(y%x, x));
    }

}
