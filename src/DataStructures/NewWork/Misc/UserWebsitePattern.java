package DataStructures.NewWork.Misc;

import java.util.*;

public class UserWebsitePattern {
    public static void main(String[] args) {
        int[] time = {1,2,3,9,1,11,10,71,11,21,31,51,13};
        System.out.println(new UserWebsitePattern().mostVisitedPattern(null, time, null));
    }

    //After sorting with timestamp...calculate Longest common subsequence b/w each user
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        UserPattern[] userpattern = new UserPattern[timestamp.length];

        for (int i = 0; i < timestamp.length; i++) {
            userpattern[i] = new UserPattern(i);
        }

        Arrays.sort(userpattern, Comparator.comparingInt(a -> timestamp[a.idx]));

        Map<String, List<String>> map = new HashMap();
        for (UserPattern up : userpattern) {
            map.putIfAbsent(username[up.idx], new ArrayList());
            map.get(username[up.idx]).add(website[up.idx]);
        }
        List<List<String>> list = (List<List<String>>) map.values();

        return null;

    }

    private List<String> findLCSOf3Length(List<String> list1, List<String> list2) {
        List<String> list = new ArrayList<>();

        int[][] dp = new int[list1.size() + 1][list2.size() + 1];

        for (int i = 1; i <= list1.size(); i++) {
            for (int j = 1; j <= list2.size(); j++) {
                if (list1.get(i - 1).equals(list2.get(j - 1))){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return list1;
    }


    class UserPattern {
        int idx;

        public UserPattern(int idx) {
            this.idx = idx;
        }
    }
}
