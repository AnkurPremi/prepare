package DataStructures.LinkedList;

public class FlattenMultilevelDLL {

    public static void main(String[] args) {
        Node head = new Node();
        head.next = new Node();
        head.next.child = new Node();
        Node temp = head.next.child;
        temp.next = new Node();
        temp.next.next = new Node();
        temp.next.next.next = new Node();
        temp.next.next.child = new Node();
        Node temp1 = temp.next.next.child;
        temp1.next = new Node();
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
