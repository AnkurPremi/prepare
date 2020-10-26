package DataStructures.HashTable;

import java.util.*;

public class AvoidFlood {
    public static void main(String[] args) {
        int[] arr ={2,3,0,0,3,1,0,1,0,2,2};
        arr = new AvoidFlood().avoidFlood(arr);
    }

    public int[] avoidFlood1(int[] rains) {
        // the previous appeared idx of rains[i]
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                zeros.add(i);
                rains[i] = 1;
            } else {
                if (map.containsKey(rains[i])) {
                    // find the location of zero that can be used to empty rains[i]
                    Integer next = zeros.ceiling(map.get(rains[i]));
                    if (next == null) return new int[0];
                    rains[next] = rains[i];
                    zeros.remove(next);
                }
                map.put(rains[i], i);
                rains[i] = -1;
            }
        }
//        for (int i : zeros) res[i] = 1;
        return rains;
    }

    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                rains[i] = 1;
                set.add(i);
                continue;
            }
            if (map.containsKey(rains[i])) {

                //if there are dryouts available.. try using the dryout now
                if (set.size() > 0) {

                    //we will try to find out any dryout periods which are available after rain in current lake
                    Integer dryout = set.ceiling(map.get(rains[i]));

                    //if all the dryout are before the rain happend in current lake..
                    //that means we cannot use them
                    if(dryout == null)
                        return new int[0];

                    //update the dryout index with the lake
                    rains[dryout] = rains[i];

                    //put the new index of the lake
                    //which means this lake is again full and needs to be dried out if it rains again
                    map.put(rains[i], i);
                    rains[i] = -1;

                    //remove the used dryout
                    set.remove(dryout);
                }

                //no dryouts available
                else
                    return new int[0];

            } else {
                map.put(rains[i], i);
                rains[i] = -1;
            }
        }
        return rains;
    }
}
