package BitManipulation2;

/**
 * Write a function that takes an integer and returns the number of 1 bits present in its binary representation.
 * Return an integer
 */
public class NoOf1Bits {
    public static void main(String[] args) {
        int A = 11;
        System.out.println(solve(A));
    }
    static int solve(int A){
        int c = 0;
        for (int i=0; i<32; i++) {
            if ((A & (1<<i))!=0) {
                c++;
            }
        }
        return c;
    }
}
