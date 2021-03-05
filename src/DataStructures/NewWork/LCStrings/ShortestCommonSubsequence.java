package DataStructures.NewWork.LCStrings;

import java.util.Collections;

public class ShortestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abac", s2 = "cab";
        System.out.println(new ShortestCommonSubsequence().shortestCommonSupersequence(s1, s2));
    }

    String[][] cache;
    int m, n, minLen = Integer.MAX_VALUE;

    public String shortestCommonSupersequence(String s1, String s2) {
        m = s1.length(); n = s2.length();
        cache = new String[m + 1][n + 1];
        return helper(s1, s2, 0, 0, new StringBuilder());

    }

    private String helper(String s1, String s2, int i, int j, StringBuilder builder){
        if(i == m || j == n){
            if(i == m) builder.append(s2.substring(j));
            else builder.append(s1.substring(i));
            if(builder.length() < minLen) minLen = builder.length();
            return builder.toString();
        }

//        if(cache[i][j] != null) return cache[i][j];

         if(builder.length() > minLen) return "";

        int len = builder.length();
        String ans = null;

        if(s1.charAt(i) == s2.charAt(j)){
            builder.append(s1.charAt(i));
            ans = helper(s1, s2, i + 1, j + 1, builder);
            builder.setLength(len);
        } else{
            builder.append(s1.charAt(i));
            String v1 = helper(s1, s2, i + 1, j, builder);
            builder.setLength(len);

            builder.append(s2.charAt(j));
            String v2 = helper(s1, s2, i, j + 1, builder);
            builder.setLength(len);

            if(v1.isEmpty()) ans = v2;
            else if (v2.isEmpty()) ans = v1;
            else ans = v1.length() < v2.length() ? v1 : v2;
        }

        cache[i][j] = ans;
        return ans;
    }

//    String ans = null;
//    public String shortestCommonSupersequence(String str1, String str2) {
//        helper(str1, str2, 0, 0, new StringBuilder());
//        return ans;
//    }
//
//    private void helper(String s1, String s2, int i, int j, StringBuilder builder){
//        if(i == s1.length() || j == s2.length()){
//            if(i == s1.length()) builder.append(s2.substring(j));
//            else builder.append(s1.substring(i));
//            String s = builder.toString();
//            if(ans == null || ans.length() > s.length()) ans = s;
//            return;
//        }
//
//        if(ans != null && builder.length() > ans.length()) return;
//
//        int len = builder.length();
//        if(s1.charAt(i) == s2.charAt(j)){
//            builder.append(s1.charAt(i));
//            helper(s1, s2, i + 1, j + 1, builder);
//            builder.setLength(len);
//        } else{
//            builder.append(s1.charAt(i));
//            helper(s1, s2, i + 1, j, builder);
//            builder.setLength(len);
//
//            builder.append(s2.charAt(j));
//            helper(s1, s2, i, j + 1, builder);
//            builder.setLength(len);
//        }
//    }
}
