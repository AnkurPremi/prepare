package DataStructures.NewWork.Misc;

import java.util.HashMap;
import java.util.Map;

public class LFUCacheHelper {
}


class LFUCache {

    Map<Integer, Pair> freqListMap;
    Map<Integer, DLLNode> keyNodeMap;
    int capacity = 0;
    int leastFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqListMap = new HashMap<>();
        keyNodeMap = new HashMap<>();
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {
        DLLNode node;
        if (!keyNodeMap.containsKey(key)) {
            node = new DLLNode(key, value, 0);
        } else {
            node = extractNode(key);
            node.freq = 0;
            node.value = value;
        }

        keyNodeMap.put(key, node);

        if (!freqListMap.containsKey(0)) {
            freqListMap.put(0, new Pair(node, node));
        } else {
            Pair p = freqListMap.get(0);
            node.next = p.head;
            p.head.prev = node;
            p.head = node;
        }

        if(keyNodeMap.size() >= capacity){
            evictTailForMinFreq();
        }
    }

    private void evictTailForMinFreq(){
        if(freqListMap.containsKey(leastFreq)){
            Pair p = freqListMap.get(leastFreq);
            DLLNode temp = p.tail.prev;
            if (p.tail.prev != null) {
                p.tail.prev.next = null;
            }
            p.tail = temp;
        }
    }

    private DLLNode extractNode(int key) {
        DLLNode node = keyNodeMap.get(key);
        Pair p = freqListMap.get(node.freq);
        if (node == p.head) {
            DLLNode temp = p.head.next;
            if (p.head.next != null) {
                p.head.next.prev = null;
            }
            p.head = temp;
        } else if (node == p.tail) {
            DLLNode temp = p.tail.prev;
            if (p.tail.prev != null) {
                p.tail.prev.next = null;
            }
            p.tail = temp;
        } else {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }

        if (p.head == p.tail && p.tail == null) {
            freqListMap.remove(node.freq);
        }
        return node;
    }

    class DLLNode {
        int key, value, freq;
        DLLNode next, prev;

        DLLNode(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    class Pair {
        DLLNode head, tail;

        Pair(DLLNode head, DLLNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}

