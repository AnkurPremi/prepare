package DataStructures.NewWork.DP;

public class MinCostPaintHouse {
    public static void main(String[] args) {
        int[] house = {2, 2, 1, 2, 2};
        int[][] costs = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        int m = 5;
        int n = 2;
        int target = 3;
        System.out.println(new MinCostPaintHouse().minCost(house, costs, m, n, target));
    }

    int[] houses = null;
    int[][] costs = null;
    int t = 0;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.costs = cost;
        this.t = target;
        int val = helper(0, 0, -1);
        return val == 0 ? -1 : val;
    }

    private int helper(int idx, int ne, int prev) {
        if (ne > t) return Integer.MAX_VALUE;
        if (idx == houses.length) {
            if (ne == t) return 0;
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        if (houses[idx] == 0) {
            for (int i = 1; i <= costs[idx].length; i++) {
                int val = helper(idx + 1, prev != i ? ne + 1 : ne, i);
                if (val != Integer.MAX_VALUE)
                    min = Math.min(min, costs[idx][i - 1] + val);
            }
        } else {
            min = helper(idx + 1, prev != houses[idx] ? ne + 1 : ne, houses[idx]);
        }
        return min;
    }
}
