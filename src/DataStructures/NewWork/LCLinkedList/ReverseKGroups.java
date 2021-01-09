package DataStructures.NewWork.LCLinkedList;


import java.util.LinkedList;
import java.util.Queue;

public class ReverseKGroups {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        node = new ReverseKGroups().reverseKGroup(head, 5);
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }

        int toRemain = len % k;

        return helper(head, k, len, toRemain);
    }

    private ListNode helper(ListNode head, int k, int count, int toRemain) {
        if (head == null || count == toRemain) return head;

        ListNode prevHead = head;
        ListNode newHead = null, curr = head;

        for (int i = 0; i < k; i++) {
            curr = head.next;
            head.next = newHead;
            newHead = head;
            head = curr;
        }

        prevHead.next = helper(head, k, count - k, toRemain);

        return newHead;
    }


//    public ListNode reverseKGroup(ListNode head, int k) {
//        int total = 0;
//        ListNode temp = head;
//        while (temp != null) {
//            total++;
//            temp = temp.next;
//        }
//
//        return reverse(head, k, total, total);
//    }
//
//    private ListNode reverse(ListNode head, int k, int left, int total) {
//        if (left < k) return head;
//
//        int rev = 0;
//        ListNode temp = null, prev = null, root = head;
//        while (rev < k) {
//            rev++;
//            temp = head.next;
//            head.next = prev;
//            prev = head;
//            head = temp;
//        }
//
//        root.next = reverse(head, k, left - k, total);
//        return prev;
//    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
            next = null;
        }
    }
}
