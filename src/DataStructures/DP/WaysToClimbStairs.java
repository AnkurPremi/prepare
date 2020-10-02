package DataStructures.DP;

import java.util.HashMap;
import java.util.Map;

public class WaysToClimbStairs {
    public static void main(String[] args) {
        System.out.println(new WaysToClimbStairs().climbStairs(4));
    }

    //if we have reached nth step.. then there are 2 posibilities.. either coming from n-1th step or (n-2)th step
    //f(n) = f(n-1) + f(n-2);
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs(n, map);
    }

    public int climbStairs(int n, Map<Integer, Integer> map) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ways = climbStairs(n - 1, map) + climbStairs(n - 2, map);
        map.put(n, ways);
        return ways;
    }
}
