package DataStructures.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String  p = "abc";
        new FindAnagrams().findAnagrams2(s, p);
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList();
        int start = 0, end = 0;
        int[] counts = new int[26];
        for(int i = 0 ; i < p.length() ; i++){
            counts[p.charAt(i) - 'a']++;
        }

        while(end < s.length()){
            char c = s.charAt(end);
            if(counts[c - 'a'] > 0){
                end++;
                counts[c - 'a']--;
            } else if(start == end){
                start++;
                end++;
            } else {
                counts[s.charAt(start) - 'a']++;
                start++;
            }

            if(end - start == p.length()){
                ans.add(start);
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        int m = s.length(), n = p.length();
        if(m * n == 0) return list;

        int[] map = new int[26];
        for(int i = 0 ; i < p.length() ; i++){
            map[p.charAt(i) - 'a']++;
        }

        int start = 0, end = 0;
        int count = p.length();

        while(end < s.length()){
            if(map[s.charAt(end) - 'a'] > 0){
                map[s.charAt(end) - 'a']--;
                end++;
            } else if(start == end){
                start++;
                end++;
            } else{
                map[s.charAt(start) - 'a']++;
                start++;
            }

            if(end - start == count){
                list.add(start);
                map[s.charAt(start) - 'a']++;
                start++;
            }
        }

        return list;
    }
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[26]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c-'a']++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)-'a'] >= 1) {
                count--;
            }
            hash[s.charAt(right)-'a']--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            s.indexOf("asd");
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {

                if (hash[s.charAt(left)-'a'] >= 0) {
                    count++;
                }
                hash[s.charAt(left)-'a']++;
                left++;

            }


        }
        return list;
    }
}
