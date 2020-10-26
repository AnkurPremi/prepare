package DataStructures.HashTable;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class FirstUnique {
    public static void main(String[] args) {
        Stream s = new Stream();
        s.add(2);
        System.out.println(s.getFirstUnique()); // 2
        s.add(2);
        System.out.println(s.getFirstUnique());
        s.add(3);
        System.out.println(s.getFirstUnique()); // 3
        s.add(4);
        System.out.println(s.getFirstUnique()); // 3
        s.add(3);
        System.out.println(s.getFirstUnique()); // 4
    }


}


class Stream {
    LinkedHashSet<Integer> set;

    public Stream() {
        set = new LinkedHashSet<>();
        // do intialization if necessary
    }

    /**
     * Adds integer num to a stream of integers.
     */
    public void add(int num) {
        if (!set.add(num)) {
            set.remove(num);
        }
        // write your code here
    }

    /**
     * Returns the first unique integer in the stream if found else return null.
     */
    public Integer getFirstUnique() {
        // write your code here
        Iterator<Integer> iterator = set.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}