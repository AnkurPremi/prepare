package DataStructures.NewWork.LCLinkedList;

public class LLCycleDetection {
    public static void main(String[] args) {
        int[] arr = {-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5};
        ListNode head = new ListNode(-21);
        ListNode node = head;
        ListNode cycleNode = null;
        for (int i = 1; i < arr.length-1; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
            if(i == 24)
                cycleNode = node;
        }
        node.next = new ListNode(arr[arr.length-1]);
        node.next.next = cycleNode;

        node = new LLCycleDetection().detectCycle(head);
    }


    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

//        while(fast != null && slow != null){
//            fast = fast.next;
//            if(fast == null) return null;
//            if(fast == slow) break;
//            fast = fast.next;
//            if(fast == null) return null;
//            if(fast == slow) break;
//            slow = slow.next;
//        }
//
//        slow = head;
//        while(fast != slow){
//            fast = fast.next;
//            slow = slow.next;
//        }
//
//        return slow;
////
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == head || slow == head)
                return head;
            if(fast == slow)
                break;
        }
        if(fast == null) return null;
        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
