package DataStructures.strings;

//https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
public class SmallestSubsequenceofDistinctCharacters {
    public static void main(String[] args) {
        String text = "cdadabcc";
        new SmallestSubsequenceofDistinctCharacters().smallestSubsequence(text);
    }

    public String smallestSubsequence(String text) {
        if(text.length() == 1) return text;
        int[] map = new int[26];
        int uniqueChars = 0;
        boolean[] seen = new boolean[26];
        for(char c : text.toCharArray()){
            if(map[c-'a'] == 0){
                map[c - 'a']++;
                seen[c-'a'] = true;
                uniqueChars++;
            }
        }
        int start = 0;
        int end = 0;
        int val = 0;
        char[] charArr = new char[text.length()];
        String finalStr = "";
        while (start < text.length()-uniqueChars){
            if(end < text.length()  && map[text.charAt(end)-'a'] > 0 && seen[text.charAt(end)-'a']) {
                val += 1;
                charArr[end] = text.charAt(end);
                seen[text.charAt(end)-'a'] = false;
                end++;
            }else{
                end++;
            }
            if (val == uniqueChars) {
                if (map[text.charAt(start) - 'a'] > 0) {
                    seen[text.charAt(start) - 'a'] = true;
                    String s1 = new String(charArr);
                    if(finalStr.isEmpty()) finalStr = s1;
                    if(finalStr.compareTo(s1) > 0){
                        finalStr = s1;
                    }
                    val--;
                    charArr[start] = Character.MIN_VALUE;
                }
                start++;
            }

        }

//        System.out.println("check");
        return null;
    }
}
