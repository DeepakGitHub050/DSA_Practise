package BitManipulation2;

/**
 * Reverse the bits of an 32 bit unsigned integer A.
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 */
public class ReverseBits {
    public static void main(String[] args) {
        long A = 0;
        System.out.println(solve(A));
    }
    static long solve(long A){
        long res = 0;
        for (int i=0; i<32; i++){
            long lsb = A & 1;
            long revlsb = lsb << (31-i);
            res = res | revlsb;
            A = A>>1;
        }
        return res;
    }
}
