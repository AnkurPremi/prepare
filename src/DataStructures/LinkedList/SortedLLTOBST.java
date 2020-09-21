package DataStructures.LinkedList;

import DataStructures.Trees.TreeNode;

public class SortedLLTOBST {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
//        node.next.next.next.next.next.next = new ListNode(7);
        TreeNode ans = new SortedLLTOBST().sortedListToBST(node);
        System.out.println("dasdasd");
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode midB4 = getMid(head);
        ListNode mid = midB4.next;
        if (mid == null) return new TreeNode(midB4.val);
        TreeNode root = new TreeNode(mid.val);
        ListNode right = mid.next;
        mid.next = null;
        midB4.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(right);
        return root;
    }

    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        return prev;
    }
}
