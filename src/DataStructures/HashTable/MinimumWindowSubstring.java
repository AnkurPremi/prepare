package DataStructures.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

        int k = 1;
//        while (k == 1) {
//            Integer a = 1000, b = 1000;  //1
//            System.out.println(a == b);
//
//            Integer c = 100, d = 100;  //2
//            System.out.println(c == d);
//        }
        String s = "acbbaca";
        String t = "aba";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        int minSize = Integer.MAX_VALUE;
        int[] window = {0, 0};

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        int uniqueReqChars = freqMap.size();
        int start = 0, end = 0;
        Map<Character, Integer> currentChars = new HashMap<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            int count = currentChars.getOrDefault(c, 0);
            currentChars.put(c, count + 1);

            //if the required character c.. is present in the current window and with the same required frequency
            //then reduce the required char count
            if (freqMap.containsKey(c) && freqMap.get(c).intValue() == currentChars.get(c).intValue()) {
                uniqueReqChars--;
            }

            while (start <= end && uniqueReqChars == 0) {
                c = s.charAt(start);
                if (minSize > (end - start + 1)) {
                    minSize = (end - start + 1);
                    window[0] = start;
                    window[1] = end;
                }

                //removing the character at the start from the window
                currentChars.put(c, currentChars.get(c) - 1);

                //check if the character at the start was one of the required character
                if (freqMap.containsKey(c) && currentChars.get(c).intValue() < freqMap.get(c).intValue()) {
                    uniqueReqChars++;
                }
                start++;
            }
            end++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(window[0], window[1] + 1);
    }
}


//
//package DataStructures.HashTable;
//
//        import java.util.HashSet;
//        import java.util.Set;
//
//public class MinimumWindowSubstring {
//    public static void main(String[] args) {
//
//        int k =1;
//        while(k==1) {
//            Integer a = 1000, b = 1000;  //1
//            System.out.println(a == b);
//
//            Integer c = 100, d = 100;  //2
//            System.out.println(c == d);
//        }
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
//    }
//
//    public String minWindow(String s, String t) {
//        if (s.equals(t)) return s;
//        if (s.length() < t.length()) return "";
//
//        int minSize = Integer.MAX_VALUE;
//        int[] window = {0, 0};
//
//        int[] map = new int[26];
//        Set<Character> set = new HashSet<>();
//        for (char c : t.toCharArray()) {
//            map[c - 'A']++;
//            set.add(c);
//        }
//        int start = 0, end = 0;
//        int count = t.length();
//        boolean found = false;
//        while(end < s.length()){
//            char c = s.charAt(end);
//            if(map[c-'A'] > 0){
//                count--;
//            }
//            map[c-'A']--;
//
//            if(count == t.length()){
//                start++;
//                end++;
//                continue;
//            }
//
//            if(count == 0){
//                if(minSize > end - start){
//                    minSize = end - start;
//                    window[0] = start;
//                    window[1] = end;
//                }
//                found=true;
//            }
//            if(!found) end++;
//
//            if(found){
//                found=false;
//                map[s.charAt(start)-'A']++;
//                count++;
//                start++;
//                boolean wasHere = false;
//                while(set.contains(s.charAt(start)) && (s.charAt(start) == s.charAt(start-1))){
//                    wasHere = true;
//                    map[s.charAt(start)-'A']++;
//                    if(minSize < end - start){
//                        minSize = end - start;
//                        window[0] = start;
//                        window[1] = end;
//                    }
//                    start++;
//                }
//                if(wasHere) {
//                    start--;
//                    map[s.charAt(start)-'A']--;
//                }
//
//                while (!wasHere && !set.contains(s.charAt(start))){
//                    start++;
//                }
//                end++;
//            }
//
//        }
//        while(end - start >= t.length()){
//
//        }
//        return "";
//    }
//}
