package DataStructures.NewWork.DP;

public class MinJobDifficulty {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        System.out.println(new MinJobDifficulty().minDifficulty(arr, 2));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        return helper(d, 0, jobDifficulty.length, jobDifficulty);
    }

    private int helper(int d, int idx, int len, int[] jd){
        if(idx == len && d == 0) return 0;
        if(idx == len || d == 0) return Integer.MAX_VALUE;

        int maxHere = jd[idx];
        int min = Integer.MAX_VALUE;
        for(int i=idx ; i<len ; i++){
            maxHere = Math.max(maxHere, jd[i]);
            int val = helper(d-1, idx+1, len, jd);
            if(val != Integer.MAX_VALUE){
                min = Math.min(min, maxHere + val);
            }
        }
        return min;
    }
}