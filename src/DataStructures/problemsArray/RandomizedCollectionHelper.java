package DataStructures.problemsArray;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedCollectionHelper {
    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
    }
}

class RandomizedCollection {

    List<Integer> list = null;
    Map<Integer, Set<Integer>> map = null;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>(Arrays.asList(list.size())));
            list.add(val);
            return true;
        }
        map.get(val).add(list.size());
        list.add(val);
        return false;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Set<Integer> posList = map.get(val);
            int pos = posList.iterator().next();
            if (pos != list.size() - 1) {
                int valAtLast = list.get(list.size() - 1);
                list.set(pos, valAtLast);
                Set<Integer> newList = map.get(valAtLast);
                newList.remove(list.size() - 1);
                newList.add(pos);
                map.put(valAtLast, newList);
            }
            list.remove(list.size() - 1);
            posList.remove(pos);
            if (posList.size() == 0) {
                map.remove(val);
            }
            return true;
        }
        return false;
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