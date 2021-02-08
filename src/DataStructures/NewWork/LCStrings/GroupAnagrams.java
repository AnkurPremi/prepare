package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(arr));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for (String str : strs) {
            String newStr = getFreqMapStr(str);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList());
            }
            map.get(newStr).add(str);
        }

        return new ArrayList(map.values());
    }

    private String getFreqMapStr(String s) {
        char[] freqMap = new char[26];

        for (char c : s.toCharArray()) {
            freqMap[c - 'a']++;
        }
        return String.valueOf(freqMap);
    }
}
