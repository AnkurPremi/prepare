package DataStructures.LinkedList;

public class AddTwoNumbersEasy {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(0);
        node1.next.next = new ListNode(9);
        node1.next.next.next = new ListNode(9);
        node = new AddTwoNumbersEasy().addTwoNumbers(node, node1);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l1.val == 0) return l2;
        if(l2 == null || l2.val == 0) return l1;

        ListNode dummyHead = new ListNode(0), curr = dummyHead;
        int num = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){
                num += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                num += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(num%10);
            curr = curr.next;
            num = num/10;
        }

        if(num != 0){
            curr.next = new ListNode(num);
        }
        return dummyHead.next;
    }
}
