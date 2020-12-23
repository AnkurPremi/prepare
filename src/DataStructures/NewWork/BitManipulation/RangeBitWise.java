package DataStructures.NewWork.BitManipulation;

public class RangeBitWise {
    public static void main(String[] args) {
        System.out.println(new RangeBitWise().rangeBitwiseAnd(6, 7));
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        if (m == n) return m;

        int bl = 0, bu = 0;
        while (m != 0) {
            bl++;
            m >>= 1;
        }

        while (n != 0) {
            bu++;
            n >>= 1;
        }

        if (bl != bu) return 0;
        return 1 << (bl-1);
    }
}
