package DataStructures.DP;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        String s = "asdadad";
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(arr));
    }

    public int minCostClimbingStairs(int[] cost) {
        int minCost1 = 0;
        int minCost2 = 0;
        for(int i : cost){
            int temp = minCost2;
            minCost2 = i + Math.min(minCost1, minCost2);
            minCost1 = temp;
        }
        //at the end.. we can either jump 2 steps from second last step.. or jump 1 step at the last step
        //return the min of two
        return Math.min(minCost1, minCost2);
    }
}
