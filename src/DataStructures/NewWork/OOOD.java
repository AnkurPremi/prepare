package DataStructures.NewWork;

public class OOOD {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }


}

class MyHashMap {

    ListNode[] arr;
    int size;
    /** Initialize your data structure here. */
    public MyHashMap() {
        size = 1000;
        arr = new ListNode[size];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = getHash(key);
        insert(key, value, hash);
    }

    private void insert(int key, int val, int hash){
        ListNode nextNode = arr[hash];
        ListNode prev = null;
        if(nextNode == null){
            arr[hash] = new ListNode(key, val);
        } else {
            while(nextNode != null){

                //update
                if(nextNode.key == key){
                    nextNode.val = val;
                    return;
                }

                prev = nextNode;
                nextNode = nextNode.next;
            }

            //insert
            prev.next = new ListNode(key, val);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = getHash(key);
        ListNode node = getNode(hash, key);
        return node == null ? -1 : node.val;
    }

    private ListNode getNode(int hash, int key){
        ListNode node = arr[hash];
        while(node != null){
            if(node.key == key) return node;
            node = node.next;
        }
        return null;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = getHash(key);
        ListNode prev = null;
        ListNode nextNode = arr[hash];
        if(nextNode.key == key){
            arr[hash] = nextNode.next;
            nextNode.next = null;
            return;
        }
        while(nextNode != null){
            if(nextNode.key == key){
                prev.next = nextNode.next;
                return;
            }
            prev = nextNode;
        }
    }


    private int getHash(int key){
        return key % size;
    }

    class ListNode{
        int key, val;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

