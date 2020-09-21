package Interview;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithNoRepeatChars {
    public static void main(String[] args) {
        String s = "abcdeabcdefgabcdeafghi";
        System.out.println(new LongestSubStringWithNoRepeatChars().getMaxLength(s));
    }

    public int getMaxLength(String s){
        if(s == null || s.isEmpty()) return 0;
        int len = s.length();
        int max = 0;
        int start = 0, end = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(end < len){
            if(map.containsKey(s.charAt(end))){
                max = Math.max(max, end-start);
                start = map.get(s.charAt(end)) + 1;
            }
            map.put(s.charAt(end), end);
            end++;
        }

        return Math.max(max, end-start);
    }


}
