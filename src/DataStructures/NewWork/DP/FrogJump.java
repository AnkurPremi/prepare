package DataStructures.NewWork.DP;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {0,1,3,5,6,8,12,17};
        System.out.println(new FrogJump().canCross(arr));
    }

    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < stones.length; i++)
            map.put(stones[i], i);
        Map<Integer, Map<Integer, Boolean>> cache = new HashMap();
        return helper(stones, 0, 0, map, cache);
    }

    private boolean helper(int[] stones, int idx, int jump, Map<Integer, Integer> map, Map<Integer, Map<Integer, Boolean>> cache) {
        if (jump < 0) return false;
        if (idx == stones.length - 1) return true;
        if (cache.containsKey(idx) && cache.get(idx).containsKey(jump)) {
            return cache.get(idx).get(jump);
        }
        boolean canReachEnd = false;
        if (idx + jump - 1 > idx && map.containsKey(stones[idx] + jump - 1)) {
            canReachEnd = helper(stones, map.get(stones[idx] + jump - 1), jump - 1, map, cache);
        }

        if (!canReachEnd && jump != 0 && map.containsKey(stones[idx] + jump)) {
            canReachEnd = helper(stones, map.get(stones[idx] + jump), jump, map, cache);
        }

        if (!canReachEnd && map.containsKey(stones[idx] + jump + 1)) {
            canReachEnd = helper(stones, map.get(stones[idx] + jump + 1), jump + 1, map, cache);
        }

        if (!cache.containsKey(idx)) {
            cache.put(idx, new HashMap<Integer, Boolean>());
        }
        cache.get(idx).put(jump, canReachEnd);
        return canReachEnd;
    }
}
