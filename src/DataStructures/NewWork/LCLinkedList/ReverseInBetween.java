package DataStructures.NewWork.LCLinkedList;

public class ReverseInBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new ReverseInBetween().reverseBetween(head, 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode tempHead = head;
        ListNode prev = null;
        for (int i = 1; i < m; i++) {
            prev = head;
            head = head.next;
        }

        ListNode currHead = head;
        ListNode temp = null, curr = null;
        for (int i = m; i <= n; i++) {
            curr = head.next;
            head.next = temp;
            temp = head;
            head = curr;
        }

        //full reverse
        if(m == 1 && head == null){
            return temp;
        } else if(m == 1){
            currHead.next = head;
            return temp;
        } else{
            if(prev != null) prev.next = temp;
            currHead.next = head;
            return tempHead;
        }
    }
}
