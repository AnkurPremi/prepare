package DataStructures.NewWork.LCStrings;

public class RestoreTheArray {
    public static void main(String[] args) {
        String s = "407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415";
        int k = 823924906;
        System.out.println(new RestoreTheArray().numberOfArrays(s, k));
    }

    Long[][] cache;
    long mod = (long) 1e9 + 7;

    public int numberOfArrays(String s, int k) {
        cache = new Long[s.length() + 1][2];
        long ans = helper(s, k, 0, 0, 0);
        return (int)(ans % mod);
    }

    private long helper(String s, int k, int idx, int num, int cut) {
        if (idx == s.length() && num <= k) return 1;

        if(cache[idx][cut] != null) return cache[idx][cut];

        if (num > k) return 0;

        long ans = 0;

        //same group
        int v = num * 10 + s.charAt(idx) - '0';
        if (v <= k) {
            ans = helper(s, k, idx + 1, v, 0);
        }
//        ans %= mod;

        //diff group
        if (num != 0 && s.charAt(idx) != '0') {
            ans += helper(s, k, idx + 1, s.charAt(idx) - '0', 1);
//            ans %= mod;
        }

        return cache[idx][cut] = ans % mod;
    }
}
