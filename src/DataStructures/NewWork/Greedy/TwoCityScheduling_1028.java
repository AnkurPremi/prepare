package DataStructures.NewWork.Greedy;

import java.util.Arrays;

public class TwoCityScheduling_1028 {
    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(new TwoCityScheduling_1028().twoCitySchedCost(costs));
    }

    public int twoCitySchedCost(int[][] costs) {
        int[] refund = new int[costs.length];
        int idx = 0;
        int costToA = 0;
        for(int[] arr : costs){
            costToA += arr[0];
            refund[idx++] = arr[1] - arr[0];
        }
        Arrays.sort(refund);
        for(int i = 0 ; i < costs.length / 2 ; i++){
            costToA += refund[i];
        }
        return costToA;
    }
}
/**
 The problem is to send n persons to city A
 and n persons to city B with minimum cost.

 The idea is to send each person to city A.
 costs = [[10,20],[30,200],[400,50],[30,20]]

 So, totalCost = 10 + 30 + 400 + 30 = 470

 Now, we need to send n persons to city B.
 Which persons do we need to send city B?

 Here, we need to minimize the cost.
 We have already paid money to go to city A.
 So, Send the persons to city B who get more refund
 so that our cost will be minimized.

 So, maintain refunds of each person
 refund[i] = cost[i][1] - cost[i][0]

 So, refunds of each person
 refund = [10, 170, -350, -10]

 Here, refund +ve means we need to pay
 -ve means we will get refund.

 So, sort the refund array.

 refund = [-350, -10, 10, 170]

 Now, get refund for N persons,
 totalCost += 470 + -350 + -10 = 110

 So, minimum cost is 110

 **/


//Greedy - After sort - O(NlogN)
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int min = Integer.MAX_VALUE;
        int[] refund = new int[costs.length];
        int idx = 0;
        int costToA = 0;
        for(int[] arr : costs){
            costToA += arr[0];
            refund[idx++] = arr[1] - arr[0];
        }

        Arrays.sort(refund);
        for(int i = 0 ; i < costs.length / 2 ; i++){
            costToA += refund[i];
        }
        return costToA;
    }
}


//Recursion with memoization - O(N^2)
// class Solution {
//     static final int MAX = Integer.MAX_VALUE;
//     int[][] dp = null;
//     public int twoCitySchedCost(int[][] costs) {
//         this.dp = new int[costs.length + 1][costs.length + 1];
//         for(int[] arr : dp) Arrays.fill(arr, -2);
//         return helper(costs, 0, 0, costs.length);
//     }

//     private int helper(int[][] costs, int idx, int c1, int n){
//         if(dp[idx][c1] != -2) return dp[idx][c1];
//         if(idx == costs.length){
//             if(c1 == n / 2) return 0;
//             return -1;
//         }

//         int ans = MAX;

//         //cityA
//         int cityA = helper(costs, idx + 1, c1 + 1, n);
//         if(cityA >= 0 && cityA < MAX){
//             ans = Math.min(ans, costs[idx][0] + cityA);
//         }
//         //cityB
//         int cityB = helper(costs, idx + 1, c1, n);
//         if(cityB >= 0 && cityB < MAX){
//             ans = Math.min(ans, costs[idx][1] + cityB);
//         }
//         ans = ans == MAX ? -1 : ans;

//         return dp[idx][c1] = ans;
//     }
// }