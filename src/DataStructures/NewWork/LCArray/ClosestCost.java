package DataStructures.NewWork.LCArray;

public class ClosestCost {
    public static void main(String[] args) {
        int[] base = {9015,4152,7816,5153,1641,3402,5201};
        int[] top = {650,447,173,4843};
        int target = 9775;
        System.out.println(new ClosestCost().closestCost(base, top, target));
    }


    int ans = Integer.MAX_VALUE;
    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target) {
        ans = baseCosts[0];
        for (int base : baseCosts)
            helper(toppingCosts, target, base, 0);
        return ans;
    }

    private void helper(int[] top, int target, int cost, int idx) {
        if (Math.abs(target - ans) > Math.abs(target - cost)) {
            ans = cost;
        } else if (Math.abs(target - ans) == Math.abs(target - cost)) {
            ans = Math.min(ans, cost);
        }

        if (idx == top.length) return;

        for (int i = 0; i <= 2; i++) {
            helper(top, target, cost + top[idx] * i, idx + 1);
        }
    }

    int res = 0;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target)
    {

        for(int i = 0; i < baseCosts.length; i++)
        {
            int sum = 0;

            close(toppingCosts, target, sum + baseCosts[i], 0);
        }

        return res;

    }



    public void close(int toppingCosts[], int target, int sum, int i)
    {
        if (Math.abs(target - res) > Math.abs(target - sum)) {
            res = sum;
        } else if (Math.abs(target - res) == Math.abs(target - sum)) {
            res = Math.min(res, sum);
        }

        if (i == toppingCosts.length) return;

        if(sum <= target)
        {
            res = Math.max(res, sum);
        }

        int op1 = toppingCosts[i] * 0;

        int op2 = toppingCosts[i] * 1;

        int op3 = toppingCosts[i] * 2;

        close(toppingCosts, target, sum + op1, i+1);

        close(toppingCosts, target, sum + op2, i+1);

        close(toppingCosts, target, sum + op3, i+1);


    }

}
