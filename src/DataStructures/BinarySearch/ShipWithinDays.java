package DataStructures.BinarySearch;

import java.util.Map;
import java.util.TreeMap;

public class ShipWithinDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(new ShipWithinDays().shipWithinDays(weights, D));
    }

    public int shipWithinDays1(int[] weights, int D) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            map.put(total, i);
        }

        int l = total / D, r = total;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int m = (l + r) >> 1;
            int val = isValidWeight(m, map, D, total, weights.length - 1);
            if (val == 0) {
                ans = m;
                r = m - 1;
            } else if (val == 1)
                r = m - 1;
            else
                l = m + 1;
        }
        return ans;
    }

    public int isValidWeight(int weight, TreeMap<Integer, Integer> map, int d, int total, int max) {
        Map.Entry<Integer, Integer> floor = null;
        int start = weight;
        while (d > 0) {
            --d;
            floor = map.floorEntry(start);
            if (floor == null && d > 0) return -1;
            if (floor.getValue() == max && d > 0) return 1;
            start = weight + floor.getKey();
        }
        if (floor != null && total - floor.getKey().intValue() > 0) return -1;
        return 0;
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
