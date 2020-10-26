package DataStructures.HashTable;


import java.util.*;

public class TimeMap {

    Map<String, List<Pair>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int time) {
        map.computeIfAbsent(key, x -> new ArrayList<Pair>()).add(new Pair(time, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, null);
        if(list == null)  return null;
        return doBinarySearch(list, timestamp);
    }

    public String doBinarySearch(List<Pair> list, int time){
        int start = 0;
        int end = list.size()-1;
        while(start < end){
            int mid = (start+end) >>1;
            int t1 = list.get(mid).time;
            if(t1 == time){
                return list.get(mid).val;
            }
            if(t1 > time){
                end = mid-1;
            } else{
                if(list.get(mid+1).time > time) return list.get(mid).val;
                start = mid+1;
            }
        }
        return (list.get(start).time <= time ? list.get(start).val : "");
    }

    class Pair{
        int time;
        String val;
        Pair(int t, String v){
            this.time = t;
            this.val = v;
        }
    }
}
