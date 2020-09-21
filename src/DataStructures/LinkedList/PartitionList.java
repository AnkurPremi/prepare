package DataStructures.LinkedList;

public class PartitionList {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(2);
        node = new PartitionList().partition(node, 3);
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;

        ListNode l1 = new ListNode(0);
        ListNode ptr1 = l1;
        ListNode l2 = new ListNode(0);
        ListNode ptr2 = l2;

        while(head != null){
            ListNode temp = head;
            head = head.next;
            if(temp.val >= x){
                ptr2.next = temp;
                ptr2 = ptr2.next;
            }else{
                ptr1.next = temp;
                ptr1 = ptr1.next;
            }
            temp.next = null;
        }
        ptr1.next = l2.next;
        return l1.next;
    }
}
