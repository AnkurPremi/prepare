package DataStructures.NewWork.LCLinkedList;

public class MyCustomLL {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }
}

class MyLinkedList {

    int size = -1;
    DLLNode head = null, tail = null;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > size) return -1;

        if(index < size >> 1){
            DLLNode temp = head;
            for(int i=0 ; i< index ; i++)
                temp = temp.next;
            return temp.val;
        } else{
            DLLNode temp = tail;
            for(int i=0 ; i<size-index ; i++)
                temp = temp.prev;
            return temp.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        size++;
        DLLNode node = new DLLNode(val);
        if(head == null){
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        size++;
        DLLNode node = new DLLNode(val);
        if(head == null){
            head = tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        DLLNode node = new DLLNode(val);
        if(index < size >> 1){
            DLLNode temp = head;
            for(int i=0 ; i<index ; i++)
                temp = temp.next;
            node.next = temp.next;
            temp.next.prev = node;
            temp.next = node;
            node.prev = temp;
        } else{
            DLLNode temp = tail;
            for(int i=0 ; i<size-index+1 ; i++)
                temp = temp.prev;
            node.next = temp.next;
            temp.next.prev = node;
            temp.next = node;
            node.prev = temp;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > size || index < 0) return;
        if(index < size >> 1){
            DLLNode temp = head;
            for(int i=0 ; i<index ; i++)
                temp = temp.next;
            temp.next = temp.next.next;
            if(temp.next != null)
                temp.next.prev = temp;
        } else{
            DLLNode temp = tail;
            for(int i=0 ; i<size-index+1 ; i++)
                temp = temp.prev;
            temp.next = temp.next.next;
            if(temp.next != null)
                temp.next.prev = temp;

        }
        size--;
    }

    class DLLNode{
        int val;
        DLLNode next;
        DLLNode prev;
        DLLNode(int val){
            this.val = val;
        }
    }
}
