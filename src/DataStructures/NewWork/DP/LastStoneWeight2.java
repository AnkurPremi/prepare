package DataStructures.NewWork.DP;

public class LastStoneWeight2 {


    //.  0,  3,  4,  7
    //0  T,  T,  T,  T
    //1  T,  T,  T,  T
    //2  F,  F,  F,  F
    //3  T,  T,  T,  T
    //4  T,  T,  T,  T
    //5  F,  F,  F,  F
    //6  F,  F,  F,  F
    //7  T,  T,  T,  T
    //8  F,  F,  F,  F

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) sum += i;
        int target = sum / 2;
        Integer[][] memo = new Integer[stones.length][target + 1];


        int remainder = dfs(memo, stones, 0, target);
        return sum - remainder * 2;
    }

    private int dfs(Integer[][] mem, int[] stones, int index, int remain) {
        if (remain == 0 || index == stones.length) return 0;
        if (mem[index][remain] != null) {
            return mem[index][remain];
        }
        mem[index][remain] = dfs(mem, stones, index + 1, remain);
        if (mem[index][remain] != remain && stones[index] <= remain) {
            mem[index][remain] = Math.max(mem[index][remain], dfs(mem, stones, index + 1, remain - stones[index]) + stones[index]);
        }
        return mem[index][remain];
    }
}