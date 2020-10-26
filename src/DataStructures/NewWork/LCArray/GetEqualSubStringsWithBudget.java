package DataStructures.NewWork.LCArray;

public class GetEqualSubStringsWithBudget {
    public static void main(String[] args) {
        String s = "fkfnkrfunni";
        String t = "jyufzxzfbsa";
        System.out.println(new GetEqualSubStringsWithBudget().equalSubstring(s, t, 18));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        if(maxCost == 0) return 1;

        int m = s.length();
        int len = 0, j=0;
        for(int i = 0; i<m ; i++){
            maxCost -= Math.abs(s.charAt(i) - t.charAt(i));
            if(maxCost < 0){
                maxCost += Math.abs(s.charAt(j) - t.charAt(j));
                len++;
            }
        }
        return m - len;
//
//        int[] dp = new int[Math.min(m, n) + 1];
//        int len = 0;
//        for(int i=1; i<= Math.min(m, n) ; i++){
//            if(s.charAt(i-1) == t.charAt(i-1)){
//                dp[i] = dp[i-1];
//            }else{
//                dp[i] = dp[i-1] + Math.abs(s.charAt(i-1) - t.charAt(i-1));
//                if(dp[i] >= maxCost){
//                    dp[i] = dp[i] - dp[i-len];
//                    len--;
//                }
//            }
//            len++;
//            maxLen = Math.max(maxLen, len);
//        }
//        return maxLen;
    }
}
