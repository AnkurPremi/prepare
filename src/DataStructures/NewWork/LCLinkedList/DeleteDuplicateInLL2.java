package DataStructures.NewWork.LCLinkedList;

public class DeleteDuplicateInLL2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new DeleteDuplicateInLL2().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevPtr = head;
        ListNode nextPtr = head.next;
        ListNode attachPtr = dummy;

        while (nextPtr != null) {

            if (prevPtr.val == nextPtr.val) {
                while (nextPtr != null && nextPtr.val == prevPtr.val)
                    nextPtr = nextPtr.next;

                if (nextPtr == null) {
                    attachPtr.next = null;
                    return dummy.next;
                } else
                    attachPtr.next = nextPtr;
            } else {
                attachPtr = prevPtr;
            }
            prevPtr = nextPtr;
            nextPtr = nextPtr.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
