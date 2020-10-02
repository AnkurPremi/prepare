package DataStructures.HashTable;

import java.util.Arrays;

public class IsoMorphicStrings {
    public static void main(String[] args) {
        System.out.println(new IsoMorphicStrings().isIsomorphic("foz", "ba"));
    }

    public boolean isIsomorphic(String s, String t) {
        int num = 0;
        int start=1;
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            if(map[c-'a'] == 0){
                map[c-'a'] = start++;
            }
            num = num*10 + map[c-'a'];
        }

        start = 1;
        int num2 = 0;
        map = new int[26];
        for(char c : t.toCharArray()){
            if(map[c-' '] == 0){
                map[c-' '] = start++;
            }
            num2 = num2*10 + map[c-'a'];
        }
        return num == num2;
    }

    public boolean isIsomorphic1(String s, String t) {
        StringBuilder builder = new StringBuilder();
        int start=1;
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            if(map[c-'a'] < 0){
                map[c-'a'] = start++;
            }
            builder.append(map[c-'a']).append(",");
        }
        start = 1;
        map = new int[26];
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(map[c-'a'] > 0){
                if(builder.charAt(i) != (char)(map[c-'a']+'0')) return false;
            }else{
                map[c-'a'] = start++;
            }
        }
        return true;
    }
}
