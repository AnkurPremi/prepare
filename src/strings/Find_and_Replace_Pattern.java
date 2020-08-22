package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-and-replace-pattern/
public class Find_and_Replace_Pattern {
    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        new Find_and_Replace_Pattern().findAndReplacePattern(words, pattern);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        String patternStr = getString(pattern, builder);
        for(String word : words){
            if(patternStr.equals(getString(word, builder))){
                result.add(word);
            }
        }
        return result;
    }

    public String getString(String pattern, StringBuilder builder){
        int[] map = new int[26];
        builder.setLength(0);
        int num = 1;
        for (int i = 0; i < pattern.length(); i++) {
            int val = map[pattern.charAt(i) - 'a'];
            if(val > 0){
                int charNum = val;
                builder.append(charNum);
            } else{
                map[pattern.charAt(i) - 'a'] = num;
                builder.append(num);
                num++;
            }
        }
        return builder.toString();
    }
}