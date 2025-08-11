package BitManipulation1;

/**
 * Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
 *
 * NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Return a single integer denoting the single element.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};
        System.out.println(solve(A));
    }
    static int solve(int[] A) {
        int ans = 0;
        for (int i=0; i<A.length; i++){
            ans = ans^A[i];
        }
        return ans;
    }
}
