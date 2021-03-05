package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequenceOfString {
    public static void main(String[] args) {
        String s = "abc";
        List<String> res = new ArrayList<>();
        new PrintAllSubsequenceOfString().helper(s, -1, new StringBuilder(), res);
        System.out.println(res);
    }

    private void helper(String s, int idx, StringBuilder builder, List<String> result){
        if(idx == s.length()) return;

        if(builder.length() > 0){
            result.add(builder.toString());
        }

        for(int i = idx + 1 ; i < s.length() ; i++){
            builder.append(s.charAt(i));
            helper(s, i, builder, result);
            builder.setLength(builder.length() - 1);
        }
    }

}
