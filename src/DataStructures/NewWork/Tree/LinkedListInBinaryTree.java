package DataStructures.NewWork.Tree;

import DataStructures.NewWork.LCLinkedList.ListNode;
import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListInBinaryTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(12);
        head.next = new ListNode(11);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next = new ListNode(13);
        System.out.println(new LinkedListInBinaryTree().isSubPath(head, null));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> A = new ArrayList(), dp = new ArrayList();
        A.add(head.val);
        dp.add(0);
        int i = 0;
        head = head.next;
        while (head != null) {
            while (i > 0 && head.val != A.get(i))
                i = dp.get(i - 1);
            if (head.val == A.get(i)) ++i;
            A.add(head.val);
            dp.add(i);
            head = head.next;
        }
        return dfs(root, 0, A, dp);
    }

    private boolean dfs(TreeNode root, int i, List<Integer> A, List<Integer> dp) {
        if (root == null) return false;
        while (i > 0 && root.val != A.get(i))
            i = dp.get(i - 1);
        if (root.val == A.get(i)) ++i;
        return i == dp.size() || dfs(root.left, i, A, dp) || dfs(root.right, i, A, dp);
    }
}
