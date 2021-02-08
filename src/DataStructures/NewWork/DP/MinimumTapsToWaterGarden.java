package DataStructures.NewWork.DP;

public class MinimumTapsToWaterGarden {
    public static void main(String[] args) {
        int n = 7;
        int[] ranges = {1,2,1,0,2,1,0,1};
        System.out.println(new MinimumTapsToWaterGarden().minTaps(n, ranges));
    }

    public int minTaps(int n, int[] ranges) {
        int[] maxRange = new int[n];
        for(int i = 0 ; i <= n ; i++){
            int left = Math.max(0, i - ranges[i]);
            maxRange[left] = Math.max(maxRange[left], i + ranges[i]);
        }

        int maxCanReach = 0;
        int maxCurrent = 0;
        int ans = 0;
        for(int i = 0 ; i < maxRange.length ; i++){
            maxCanReach = Math.max(maxCanReach, maxRange[i]);
            if(maxCurrent == i){
                ans += 1;
                maxCurrent = maxCanReach;
            }
        }
        return maxCanReach >= n ? ans : -1;
    }
}
