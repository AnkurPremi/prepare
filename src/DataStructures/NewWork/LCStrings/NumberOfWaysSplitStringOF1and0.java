package DataStructures.NewWork.LCStrings;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysSplitStringOF1and0 {
    public static void main(String[] args) {
        String s = "000";
        System.out.println(new NumberOfWaysSplitStringOF1and0().numWays(s));
    }

    public int numWays(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < s.length(); i++) {
            total += s.charAt(i) - '0';
            map.put(total, map.getOrDefault(total, 0) + 1);
        }
        if(total == 0) return (int) ((s.length() - 1) * (s.length() - 2) / 2 % mod);
        if (total % 3 != 0) return 0;

        int ans = 0;
        int count = 0;
        int maxSplit = total/3;
        for (int i = s.length() - 1; i >= 2; i--) {
            count += s.charAt(i) - '0';

            if(count > 0) {
                int val = total - count;
                if(val%2 != 0) continue;
                val /= 2;
                if(val != maxSplit) continue;
                ans = (ans + map.getOrDefault(val, 0)) % mod;
            }
        }
        return ans;
    }
}
