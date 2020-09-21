package DataStructures.LinkedList;

public class ReverseBetweenIndices {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
//        node.next.next.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next.next.next = new ListNode(-5);
//        node.next.next.next.next.next.next.next.next = new ListNode(1);
        node = new ReverseBetweenIndices().reverseBetween(node, 1, 4);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode hea1 = head;
        ListNode prev = null;
        int count = 1;
        while (count < m) {
            prev = head;
            head = head.next;
            count++;
        }
        if (prev != null)
            prev.next = null;
        ListNode tail = head;
        ListNode ptr = null;
        while (count <= n && head != null) {
            count++;
            ListNode temp = head.next;
            head.next = ptr;
            ptr = head;
            head = temp;
        }

        if (prev != null)
            prev.next = ptr;
        tail.next = head;

        return prev == null ? ptr : hea1;
    }
}
