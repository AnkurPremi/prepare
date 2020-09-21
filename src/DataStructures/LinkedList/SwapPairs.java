package DataStructures.LinkedList;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
//        node.next.next.next.next.next.next.next = new ListNode(8);
        node = new SwapPairs().swapInPairsOfK(node, 2);
        System.out.println("sdadasd");
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode restList = newHead.next;
        newHead.next = head;
        head.next = swapPairs(restList);
        return newHead;
    }

    public ListNode swapInPairsOfK(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int i = 0;
        ListNode prev = head;
        ListNode newHead = null, temp = null;
        while (i < k && head != null) {
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
            i++;
        }
        prev.next = swapInPairsOfK(head, k);
        return newHead;
    }
}
