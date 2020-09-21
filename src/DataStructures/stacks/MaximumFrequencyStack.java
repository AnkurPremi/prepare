package DataStructures.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}


class FreqStack {

    PriorityQueue<FElement> pQ;
    Map<Integer, Integer> map;
    int uid = 1;
    public FreqStack() {
        map = new HashMap<>();
        pQ = new PriorityQueue<FElement>((a, b) -> {
            if (a.frequency > b.frequency) return -1;
            else if (a.frequency < b.frequency) return 1;
            else {
                return Integer.compare(b.uid, a.uid);
            }
        });
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0)+1);
        pQ.offer(new FElement(x, uid++, map.get(x)));
    }

    public int pop() {
        FElement fe = pQ.poll();
        int element = fe.val;
        map.put(element, map.get(element) - 1);
        map.remove(element, 0);
        return element;
    }

    class FElement {
        int val;
        int uid;
        int frequency;

        FElement(int val, int uid, int frequency) {
            this.val = val;
            this.frequency = frequency;
            this.uid = uid;
        }
    }
}