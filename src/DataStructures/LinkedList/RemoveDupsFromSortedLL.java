package DataStructures.LinkedList;

public class RemoveDupsFromSortedLL {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(2);
        ListNode head = new RemoveDupsFromSortedLL().deleteDuplicates(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode newHead = head;
        ListNode start = head;
        head = head.next;
        while(head != null){
            if(head.val == start.val){
                start.next = head.next;
                start = head;
                 head = head.next;
            }else {
                start = start.next;
            }
            if(head!=null)
                head = head.next;
        }

        return newHead;
    }
}

