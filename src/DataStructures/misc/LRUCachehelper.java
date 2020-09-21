package DataStructures.misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCachehelper {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

class LRUCache {

    DLLNode head;
    DLLNode tail;
    Map<Integer, DLLNode> map;
    int size;
    int currSize;

    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            int val = map.get(key).val;
            bringNodeToHead(key, val);
            return val;
        }
    }

    public void put(int key, int value) {
        if (head == null) {
            head = tail = new DLLNode(key, value);
            map.put(key, head);
            currSize++;
        } else {
            //either the cache already has that value
            if (map.containsKey(key)) {
                bringNodeToHead(key, value);
            } else {
                currSize++;
                addNodeToHead(key, value);
                //if currSize greater than capacity.. evict tail
                if (currSize > size) {
                    evictTail(key, value);
                    currSize--;
                }
            }
        }
    }

    public void bringNodeToHead(int key, int val) {
        DLLNode node = map.get(key);
        if (node == head) {
            head.val = val;
            return;
        } else {
            if (node == tail) {
                DLLNode temp = tail.prev;
                tail.prev.next = null;
                tail.prev = null;
                tail.next = head;
                head.prev = tail;
                head = tail;
                tail = temp;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                head.prev = node;
                node.next = head;
                head = node;
            }
        }
    }


    public void evictTail(int key, int value) {
        if (head == tail) {
            map.remove(tail.key);
            head = tail = null;
        } else {
            map.remove(tail.key);
            DLLNode temp = tail.prev;
            tail.prev.next = null;
            tail.prev = null;
            tail = temp;
        }
    }

    public void addNodeToHead(int key, int value) {
        DLLNode node = new DLLNode(key, value);
        node.next = head;
        head.prev = node;
        head = node;
        map.put(key, node);
    }


    class DLLNode {
        int key;
        int val;
        DLLNode next;
        DLLNode prev;

        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
