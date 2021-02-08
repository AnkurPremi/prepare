package DataStructures.NewWork.LCArray;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FirstUniqueInQueue {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        FirstUnique fu = new FirstUnique(arr);
        System.out.println(fu.showFirstUnique());
        fu.add(5);
        System.out.println(fu.showFirstUnique());
        fu.add(2);
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());
    }

}

class FirstUnique {

    Set<Integer> dups;
    Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        dups = new HashSet<>();
        queue = new LinkedList();
        for (int num : nums) {
            queue.offer(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && dups.contains(queue.peek())) {
            dups.remove(queue.poll());
        }
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public void add(int value) {
        boolean add = true;
        while (!queue.isEmpty() && queue.peek() == value) {
            queue.poll();
            add = false;
        }
        while (!queue.isEmpty() && dups.contains(queue.peek())) {
            dups.remove(queue.poll());
        }

        if (add) {
            dups.add(value);
            queue.offer(value);
        }
    }
}

