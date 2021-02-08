package DataStructures.NewWork.Contest;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_1 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
    }
}


class LRUCache {

    DLLNode head, tail;
    Map<Integer, DLLNode> map;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        DLLNode node = removeFromTheList(key);
        if (node == null) return -1;
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLLNode node = removeFromTheList(key);
        if (node == null) {
            node = new DLLNode(key, value);
        } else {
            node.val = value;
        }

        map.put(key, node);
        addToHead(node);

        if (map.size() > capacity) {
            DLLNode tailNode = evictTail();
            map.remove(tailNode.key);
        }

    }

    class DLLNode {
        int key, val;
        DLLNode next, prev;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private DLLNode evictTail() {
        DLLNode tailNode = tail;
        DLLNode prev = tail.prev;
        if (tail.prev != null) {
            tail.prev.next = null;
        }
        if (prev != null) {
            prev.next = null;
        }
        tail = prev;

        return tailNode;
    }

    private void addToHead(DLLNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private DLLNode removeFromTheList(int key) {
        if (!map.containsKey(key)) return null;

        DLLNode node = map.get(key);

        if (node.prev != null) {
            node.prev.next = node.next;
            node.prev = null;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
            node.next = null;
        }

        return node;
    }
}