package DataStructures.LinkedList;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/reorder-list/
public class ReorderLL {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
        new ReorderLL().reorderList1(node);
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null);

        List<ListNode> list = new ArrayList<>();
//        while(head != null){
//            ListNode temp = head;
//            head = head.next;
//            temp.next = null;
//            list.add(temp);
//        }

        while(head != null){
            list.add(head);
            head = head.next;
        }

        int start = 0, end = list.size()-1;
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while(start < end){
            ptr.next = list.get(start);
            ptr = ptr.next;
            ptr.next = list.get(end);
            ptr = ptr.next;
            start++;end--;
        }
        if(list.size() %2 != 0){
            ptr.next = list.get(start);
            ptr = ptr.next;
        }
        ptr.next = null;
        head = dummy.next;
    }

    public void reorderList1(ListNode head) {
        if(head == null || head.next == null);
        ListNode mid = getMid(head);
        ListNode reverseList = mid.next;
        mid.next = null;
        reverseList = reverse(reverseList);
        head = create(head, reverseList);
    }

    public ListNode create(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0), curr = dummy;
        while(l1 != null || l2 != null){
            if(l1 != null){
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }
            if(l2 != null){
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
