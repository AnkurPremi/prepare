package DataStructures.LinkedList;

public class ReverseLL {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(2);
        System.out.println(new ReverseLL().reverseList(node));
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = null, prev = null;
        while(head != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
