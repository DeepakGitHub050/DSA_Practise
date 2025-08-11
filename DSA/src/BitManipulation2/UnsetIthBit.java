package BitManipulation2;

/**
 * You are given two integers A and B.
 * If B-th bit in A is set, make it unset.
 * If B-th bit in A is unset, leave as it is.
 * Return the updated A value.
 * Note:
 * The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.
 *
 * Return an integer.
 */
public class UnsetIthBit {
    public static void main(String[] args) {
        int A = 4, B = 1;
        System.out.println(solve(A, B));
    }
    static int solve(int A, int B){
        return A&~(1<<B);
    }
}
