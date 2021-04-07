package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxNumberOfConsecutiveVaqluesYouCanMake {
    public static void main(String[] args) {
        int[] coins = {1,1,1,4};
        System.out.println(new MaxNumberOfConsecutiveVaqluesYouCanMake().getMaximumConsecutive(coins));
    }

    private Set<Integer> set;
    private int[] coins;
    public int getMaximumConsecutive(int[] coins) {
        this.set = new HashSet();
        this.coins = coins;
        helper(0, 0);
        return 0;
    }

    private void helper(int idx, int sum){
        set.add(sum);
        if(idx == coins.length) return;
        helper(idx + 1, coins[idx] + sum);
        helper(idx + 1, sum);
    }
}
