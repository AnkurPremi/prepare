package DataStructures.NewWork.DP;

public class DiceRollSumWithLimit {
    public static void main(String[] args) {
        int[] rollMax = {1,1,2,2,2,3};
        int n = 2;
        System.out.println(new DiceRollSumWithLimit().dieSimulator(n, rollMax));
    }

    public int dieSimulator(int n, int[] rollMax) {
        return helper(n, rollMax, 0, n);
    }

    private int helper(int n, int[] rollmax, int idx, int k){
        if(k == 0) {
            if(idx == rollmax.length) return 0;
            return -1;
        }

        int ans = 0;
        for(int i = 1 ; i <= 6 ; i++){
            if(i == rollmax[idx]) continue;
            if((idx+1) % n == 0){
                ans += helper(n, rollmax,  idx + 1, k - 1);
            } else{
                ans += helper(n, rollmax,  idx + 1, k);
            }
            ans += 1;
        }

        return ans;
    }
}
