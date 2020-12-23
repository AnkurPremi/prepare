package DataStructures.NewWork.LCLinkedList;

import java.util.*;

public class Remove0SumConsecutiveNodes {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        Iterator<Integer> iterator = set.iterator();
        if(iterator.hasNext()){
            int num = iterator.next();
            iterator.remove();
            set.add(num);
        }
        int[] arr = {1, 3, 2, -3, -2, 5, 5, -5, 1};
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        node = new Remove0SumConsecutiveNodes().removeZeroSumSublists(head);
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head.next == null) return head;
        ListNode dummy = new ListNode(-1001);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);
        int sum = 0;
        while (head != null) {
            sum += head.val;
            if (map.containsKey(sum)) {
                int tempSum = sum;
                ListNode temp = map.get(sum).next;
                while(temp != head){
                    tempSum += temp.val;
                    map.remove(tempSum);
                    temp = temp.next;
                }
                map.get(sum).next = head.next;
            } else {
                map.put(sum, head);
            }
            head = head.next;
        }

        return dummy.next;
    }
}
