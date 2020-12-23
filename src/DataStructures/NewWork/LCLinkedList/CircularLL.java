package DataStructures.NewWork.LCLinkedList;

public class CircularLL {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = head;
        head = new CircularLL().insert(head, 0);
        System.out.println(":sdadsa");
    }

    public Node insert(Node head, int val) {
        Node node = new Node(val);
        if(head == null){
            node.next = node;
            return node;
        }

        Node temp = head.next;
        Node prev = head;
        while(head != temp){
            if(prev.val < val || (prev.val > temp.val && val < temp.val)){
                node.next = temp;
                prev.next = node;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        prev.next = node;
        node.next = temp;
        return node;
    }

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
}
