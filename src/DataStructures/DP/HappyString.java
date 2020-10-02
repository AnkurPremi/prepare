package DataStructures.DP;

import DataStructures.LCTrees.HasPathSum;

public class HappyString {
    public static void main(String[] args) {
        System.out.println(new HappyString().getHappyString(1, 1, 7));
    }

    public String getHappyString(int a, int b, int c) {
        return getHappyString(a, b, c, "a", "b", "c");
    }

    //first pick the elements from lg and md heap and arrange them to get the answer
    //Always keep a >= b >= c. ( first 2 conditions)
    public String getHappyString(int l, int m, int s, String lg, String md, String sm) {
        if (l < m)
            return getHappyString(m, l, s, md, lg, sm);
        if (m < s)
            return getHappyString(l, s, m, lg, sm, md);
        if (m == 0)
            return lg.repeat(Math.min(2, l));

        int use_lg = Math.min(2, l);
        int use_md = l - use_lg >= m ? 1 : 0;
        return lg.repeat(use_lg) + md.repeat(use_md) + getHappyString(l - use_lg, m - use_md, s, lg, md, sm);
    }
}
