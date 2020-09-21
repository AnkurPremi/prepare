package DataStructures.SortingAndSeraching;

import java.util.concurrent.ThreadLocalRandom;

public class MergeSortLL {
    public static void main(String[] args) {
        ListNode node = createRandomLL(10);
        node = mergeSort(node);
        System.out.println(node);
    }

    static ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) return node;

        //Find mid and divide the LL in to two parts
        ListNode mid = findMid(node);
        ListNode right = mid.next;
        mid.next = null;

        //Merge Sort left part recursively
        node = mergeSort(node);
        //Merge Sort right part recursively
        right = mergeSort(right);

        //Merge the sorted lists and return
        return merge(node, right);
    }

    static ListNode findMid(ListNode node) {
        if(node == null) return node;
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode merge(ListNode left, ListNode right) {
        ListNode temp = null;
        if (left == null) return right;
        else if (right == null) return left;
        else if (left.val <= right.val) {
            temp = left;
            left.next = merge(left.next, right);
        } else {
            temp = right;
            right.next = merge(left, right.next);
        }
        return temp;
    }

    public static ListNode createRandomLL(int length) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 0; i < length; i++) {
            int randomVal = ThreadLocalRandom.current().nextInt(1, 100);
            temp.next = new ListNode(randomVal);
            temp = temp.next;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}