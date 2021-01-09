package DataStructures.NewWork.Misc;

import java.util.HashMap;
import java.util.Map;

public class LFUCacheHelper {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}


class LFUCache {

    private int capacity;
    private Map<Integer, DLLNode> values;
    private Map<Integer, NodeList> lists;
    private int minFreq;
    private int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.values = new HashMap();
        this.lists = new HashMap();
    }

    public int get(int key) {
        if (!values.containsKey(key)) return -1;
        DLLNode node = values.get(key);
        int count = node.cnt;
        node.cnt++;

        NodeList nodeList = lists.get(count);
        nodeList.remove(node);
        if (count == minFreq && nodeList.size == 0) {
            lists.remove(count);
            minFreq++;
        }

        count += 1;
        nodeList = lists.getOrDefault(count, new NodeList());
        nodeList.add(node);

        lists.put(count, nodeList);
        values.put(key, node);

        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        DLLNode node = values.getOrDefault(key, null);
        NodeList nodeList = null;
        int count = 0;
        if (node == null) {
            node = new DLLNode(key, value);
            node.cnt++;
            count = node.cnt;
            nodeList = lists.getOrDefault(count, new NodeList());
            nodeList.add(node);
            if (size == capacity) {
                NodeList list = lists.get(minFreq);
                DLLNode lastNode = list.evictTail();
                values.remove(lastNode.key);
                size--;
            }
            minFreq = 1;
            size++;
        } else {
            node.val = value;
            count = node.cnt;
            node.cnt++;
            nodeList = lists.get(count);
            nodeList.remove(node);
            if (node.cnt == minFreq && nodeList.size == 0) {
                lists.remove(count);
                minFreq++;
            }
            count = node.cnt;
            nodeList = lists.getOrDefault(count, new NodeList());
            nodeList.add(node);
        }

        lists.put(count, nodeList);
        values.put(key, node);

    }

    class DLLNode {
        int key, val, cnt;
        DLLNode prev, next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            // cnt = 1;
        }
    }

    class NodeList {
        DLLNode head, tail;
        int size;

        NodeList() {
            head = new DLLNode(0, 0);
            tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(DLLNode node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            size++;
        }

        void remove(DLLNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        DLLNode evictTail() {
            DLLNode removed = tail.prev;
            remove(removed);
            return removed;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */