package DataStructures.HashTable;

import java.util.ArrayList;
import java.util.List;

public class FindCommmonChars {
    public static void main(String[] args) {
        String[] arr = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        System.out.println(new FindCommmonChars().commonChars(arr));
    }

    public List<String> commonChars(String[] A) {
        int n = A.length;
        int[] map = new int[26];
        List<String> result = new ArrayList();
        for (char c : A[0].toCharArray()) {
            map[c - 'a']++;
        }
        int[] mapn;
        for (int i=1; i<A.length;i++) {
            mapn = new int[26];
            boolean found = false;
            for(char c : A[i].toCharArray()){
                if(map[c-'a'] > 0){
                    found = true;
                    mapn[c-'a']++;
                    map[c-'a']--;
                }
            }
            map = mapn;
            if(!found) return result;
        }
        for (int i = 0; i < 26; i++) {
            int val = map[i] / n;
            while(val > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                val--;
            }
        }
        return result;
    }
}
