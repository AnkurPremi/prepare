package DataStructures.LinkedList;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
public class RemoveContinuesNodesWithSum0 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(-3);
        node.next.next.next.next = new ListNode(-2);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next.next = new ListNode(-5);
        node.next.next.next.next.next.next.next.next = new ListNode(1);
        node = new RemoveContinuesNodesWithSum0().removeZeroSumSublists(node);
    }

    //the whole idea of the solution is based upon..preparing prefixSum for every node in the LL and store it in the map
    //if we have seen this prefixSum earlier..that means b/w that node and the current node..sum is 0
    public ListNode remove(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (cur != null) {
            prefixSum += cur.val;
            if (map.containsKey(prefixSum)) {
                cur = map.get(prefixSum).next;
                //we will again find prefixSum and while traversing we will remove the elements in b/w and adjust the LL pointer
                int pSum = prefixSum + cur.val;
                while (pSum != prefixSum) {
                    map.remove(pSum);
                    cur = cur.next;
                    pSum += cur.val;
                }
                map.get(prefixSum).next = cur.next;
            } else {
                map.put(prefixSum, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode remove1(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (cur != null) {
            prefixSum += cur.val;
            if (map.containsKey(prefixSum)) {
                ListNode temp = map.get(prefixSum);
                temp.next = cur.next;
            } else {
                map.put(prefixSum, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int sum = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            sum += p.val;
            map.put(sum, p);
        }

        sum = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            sum += p.val;
            p.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
