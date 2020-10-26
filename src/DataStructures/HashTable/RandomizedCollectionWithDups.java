package DataStructures.HashTable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedCollectionWithDups {
    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        System.out.println(r.insert(4));
        System.out.println(r.insert(3));
        System.out.println(r.insert(4));
        System.out.println(r.insert(2));
        System.out.println(r.insert(4));
        System.out.println(r.remove(4));
        System.out.println(r.remove(3));
        System.out.println(r.remove(4));
        System.out.println(r.remove(4));
//        for(int i=0;i<10 ; i++)
//            System.out.println(r.getRandom());
    }

    static class RandomizedCollection {

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
                posList.remove(pos);
                if (pos < list.size() - 1) {
                    int valAtLast = list.get(list.size() - 1);
                    list.set(pos, valAtLast);
                    Set<Integer> newList = map.get(valAtLast);
                    newList.remove(list.size() - 1);
                    newList.add(pos);
                }
                list.remove(list.size() - 1);
                map.remove(val, 0);
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
}
