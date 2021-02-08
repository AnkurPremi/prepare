package DataStructures.NewWork.Misc;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSetDupsAllowed {
    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println(randomizedCollection.insert(4));
        System.out.println(randomizedCollection.insert(3));
        System.out.println(randomizedCollection.insert(4));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(4));
        System.out.println(randomizedCollection.remove(4));
        System.out.println(randomizedCollection.remove(3));
        System.out.println(randomizedCollection.remove(4));
        System.out.println(randomizedCollection.remove(4));
    }
}


class RandomizedCollection {

    /**
     * Initialize your data structure here.
     */
    Map<Integer, Set<Integer>> map;
    List<Integer> list;

    public RandomizedCollection() {
        list = new ArrayList();
        map = new HashMap();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean ans = map.containsKey(val);
        if (!ans) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !ans;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> coll = map.get(val);
        int removeIdx = coll.iterator().next();
        coll.remove(removeIdx);
        if (removeIdx < list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(removeIdx, lastVal);
            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(removeIdx);
        }
        if (coll.size() == 0) map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */