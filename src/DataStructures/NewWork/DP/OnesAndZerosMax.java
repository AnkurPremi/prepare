package DataStructures.NewWork.DP;

public class OnesAndZerosMax {
    public static void main(String[] args) {
        String[] arr = {"10","0001","111001","1","0"};
        System.out.println(new OnesAndZerosMax().findMaxForm(arr, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        return helper(strs, m, n, 0);
    }

    private int helper(String[] strs, int oneLeft, int zeroLeft, int idx) {
        if (idx == strs.length) return 0;
        if (oneLeft < 0 || zeroLeft < 0) return 0;

        int[] zerosOnes = calc(strs[idx]);

        int pick = 1 + helper(strs, oneLeft - zerosOnes[1], zeroLeft - zerosOnes[0], idx + 1);
        int leave = helper(strs, oneLeft, zeroLeft, idx + 1);

        return Math.max(pick, leave);
    }

    private int[] calc(String s) {
        int[] zerosOnes = {0, 0};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                zerosOnes[0]++;
            else
                zerosOnes[1]++;
        }
        return zerosOnes;
    }
}
