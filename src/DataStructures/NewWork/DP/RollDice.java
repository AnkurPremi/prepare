package DataStructures.NewWork.DP;

public class RollDice {
    public static void main(String[] args) {
        System.out.println(new RollDice().numRollsToTarget(4,6,7));
    }

    int mod = (int) 1e9 + 7;
    public int numRollsToTarget(int d, int f, int target) {
        int [] dp = new int[d+1];
        return helper(d, f, target, dp);
    }

    //check at any stage if number of dice * max facevalue is smaller than target ..return

    private int helper(int d, int f, int target, int[] dp){
        if(target < 0) return 0;
        if(d == 0){
            if(target == 0) return 1;
            return 0;
        }
        if(d * f < target) return 0;

        int count = 0;
        for(int i=1 ; i<=f ; i++){
            int val = helper(d-1, f, target - i, dp);
            count = (count + val) % mod;
        }

        return count;
    }
}
