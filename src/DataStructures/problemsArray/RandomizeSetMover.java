package DataStructures.problemsArray;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizeSetMover{
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}

class RandomizedSet {

    List<Integer> list = null;
    Map<Integer, Integer> map = null;
    Random random = null;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<Integer, Integer>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        //we are storing the value along with its index in the arrayList.
        //we are using list.size()..because the elemenet will be added at the end of the list
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int posInList = map.get(val);
        //we are checking if the element to be removed from the list is at the last position
        //if not, then the requirement of O(1) runtime will not fulfill
        //to handle the above case we can swap the elements from this position and last position
        if (posInList != list.size() - 1) {
            int elemAtLastPos = list.get(list.size() - 1);
            //this will replace the element
            list.set(posInList, elemAtLastPos);
            map.put(elemAtLastPos, posInList);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
    }
}