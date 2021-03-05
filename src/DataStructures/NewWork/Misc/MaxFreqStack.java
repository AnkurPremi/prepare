package DataStructures.NewWork.Misc;

import java.util.*;

public class MaxFreqStack {
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

    TreeMap<Integer, Deque<Integer>> map;
    Map<Integer, Integer> freqMap;

    public FreqStack() {
        map = new TreeMap();
        freqMap = new HashMap();
    }

    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        Deque<Integer> dq = map.getOrDefault(freq, new LinkedList());
        dq.addLast(x);
        freqMap.put(x, freq);
        map.put(freq, dq);
    }

    public int pop() {
        Map.Entry<Integer, Deque<Integer>> entry = map.lastEntry();
        int key = entry.getKey();
        int ans = entry.getValue().pollLast();
        if (entry.getValue().size() == 0) {
            map.remove(key);
        }
        freqMap.put(ans, freqMap.get(ans) - 1);
        freqMap.remove(ans, 0);
        return ans;
    }
}