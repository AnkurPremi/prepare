package DataStructures.HashTable;

import java.util.*;

public class SortCharsByFrq {
    public static void main(String[] args) {
        System.out.println(new SortCharsByFrq().frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        int[] map = new int[60];
        char[] result = s.toCharArray();
        int max = 0;
        for (char c : result) {
            map[c-'A']++;
            max = Math.max(max, map[c-'A']);
        }
        List<Integer>[] buckets = new List[max+1];
        for(int i=0; i<60 ; i++){
            int freq = map[i];
            if(freq==0) continue;
            else{
                if(buckets[freq] == null){
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add(i);
            }
        }
        int n = s.length()-1;
        for(int i=1 ; i< buckets.length ; i++){
            if(buckets[i] == null) continue;
            List<Integer> list = buckets[i];
            for(int j : list){
                for(int k=0; k<i ;k++){
                    result[n--] = ((char) (j +'A'));
                }
            }
        }

        return String.valueOf(result);
    }
}
