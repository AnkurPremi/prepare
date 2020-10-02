package DataStructures.DP;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(new CountBits().countBits(5));
    }

    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
