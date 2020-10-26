package DataStructures.NewWork.LCStrings;

import DataStructures.NewWork.LCArray.MaxChunksToMakeSorted2;

public class MaxScoreAfterSplittingString {
    public static void main(String[] args) {
        String s = "1111";
        System.out.println(new MaxScoreAfterSplittingString().maxScore(s));
    }

    public int maxScore(String s) {
        int n = s.length();
        int[] zeros = new int[n];
        int[] ones = new int[n];
        int ans = -1;
        zeros[0] = s.charAt(0) == '0' ? 1 : 0;
        for(int i=1 ; i<n-1 ; i++){
            zeros[i] = zeros[i-1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        ones[n-1] = s.charAt(n-1) == '1' ? 1 : 0;
        for(int i=n-2 ; i>=0 ; i--){
            ones[i] = ones[i+1] + (s.charAt(i) == '1' ? 1 : 0);
            ans = Math.max(ones[i+1] + zeros[i] , ans);
        }

        return ans;
    }
}
