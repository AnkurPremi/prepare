package DataStructures.LinkedList;

public class RemoveDupsFromLL2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(4);
        node = new RemoveDupsFromLL2().deleteDuplicates(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(head.val-1), cur = dummy;
        cur.next = head;
        ListNode start = head;
        ListNode end = head.next;
        while(end != null){
            if(start.val == end.val){
                while(end.val == start.val){
                    end = end.next;
                    if(end == null){
                        cur.next = null;
                        return dummy.next;
                    }
                }
                cur.next = end;
                start = end;
            }else{
                cur = cur.next;
                start = start.next;
            }
            end = end.next;
        }
        return dummy.next;
    }
}
