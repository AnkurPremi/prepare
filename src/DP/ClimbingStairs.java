package DP;

import java.lang.instrument.ClassDefinition;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(10));
        System.out.println(climbingStairs.climbStairs(3));
    }
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        int[] arr = new int[n+1];
        return helper(n, arr);
    }

    private int helper(int n, int[] arr){
        if(n <= 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n == 3) return 3;

        if(arr[n] != 0){
            return arr[n];
        } else{
            arr[n] = helper(n-1, arr) + helper(n-2, arr);
        }
        return arr[n];
    }
}
