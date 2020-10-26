package DataStructures.HashTable;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] arr ={"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new TopKFrequentWords().topKFrequent(arr, k));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        int bucketSize = 0;
        for(String word : words ){
            map.put(word, map.getOrDefault(word, 0) + 1);
            bucketSize = Math.max(bucketSize, map.get(word));
        }
        int count = 0;
        List<String>[] buckets = new List[bucketSize+1];
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(buckets[entry.getValue()] == null){
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        List<String> result = new ArrayList<>();
        for(int i=buckets.length-1; i >=0 && k>0 ; i--){
            List<String> list = buckets[i];
            Collections.sort(list);
            for(String s : list){
                k--;
                result.add(s);
                if(k==0) break;
            }
            k--;
        }
        return result;
    }
}
