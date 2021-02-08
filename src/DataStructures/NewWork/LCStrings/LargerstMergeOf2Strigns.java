package DataStructures.NewWork.LCStrings;

public class LargerstMergeOf2Strigns {
    public static void main(String[] args) {
        String s1 = "cabaa";
        String s2 = "bcaaa";
        System.out.println(new LargerstMergeOf2Strigns().largestMerge(s1, s2));
    }

    String result = "";
    public String largestMerge(String word1, String word2) {
        helper(word1, word2, new StringBuilder(),new String[1] , 0, 0);
        return result;
    }

    private void helper(String s1, String s2, StringBuilder merge, String[] ans, int idx1, int idx2){
        if(idx1 == s1.length() && s2.length() == idx2){
            String k = merge.toString();
            if(result.isEmpty()) result = k;
            else result = result.compareTo(k) > 0 ? result : k;
            return;
        }


        if(idx1 < s1.length() && idx2 < s2.length() && s1.charAt(idx1) > s2.charAt(idx2)){
            int len = merge.length();
            helper(s1, s2, merge.append(s1.charAt(idx1)), ans, idx1 + 1, idx2);
            merge.setLength(len);
        }


        else if(idx1 < s1.length() && idx2 < s2.length() && s1.charAt(idx1) < s2.charAt(idx2)){
            int len = merge.length();
            helper(s1, s2, merge.append(s2.charAt(idx2)), ans, idx1, idx2 + 1);
            merge.setLength(len);
        }

        else if(idx1 < s1.length() && idx2 < s2.length() && s1.charAt(idx1) == s2.charAt(idx2)){
            int len = merge.length();
            helper(s1, s2, merge.append(s1.charAt(idx1)), ans, idx1 + 1, idx2);
            merge.setLength(len);
            helper(s1, s2, merge.append(s2.charAt(idx2)), ans, idx1, idx2 + 1);
            merge.setLength(len);
        } else{
            if(idx1 < s1.length())
                helper(s1, s2, merge.append(s1.substring(idx1, s1.length())), ans, s1.length(), idx2);
            else
                helper(s1, s2, merge.append(s2.substring(idx2, s2.length())), ans, idx1, s2.length());
        }

    }
}
