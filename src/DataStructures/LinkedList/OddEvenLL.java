package DataStructures.LinkedList;

public class OddEvenLL {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
        ListNode ans = new OddEvenLL().oddEvenList(node);
        System.out.println("sdasd");
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode evenListHead = head;
        ListNode evenTemp = evenListHead;

        ListNode oddListHead = new ListNode(0);
        ListNode oddTemp = oddListHead;

        int count = 0;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            if(count%2 != 0){
                oddTemp.next = temp;
                temp.next = null;
                oddTemp = temp;
            }else{
                evenTemp.next = temp;
                temp.next = null;
                evenTemp = temp;
            }
            count++;
        }
        evenTemp.next = oddListHead.next;
        return evenListHead;
    }
}
