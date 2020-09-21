package DataStructures.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(0);
        node1.next.next = new ListNode(9);
//        node1.next.next.next = new ListNode(9);
        ListNode ans = new AddTwoNumbers().addTwoNumbers(node, node1);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        int[] carr = {0};
        ListNode temp = recursion(l1, l2, carr, len1, len2);
        if(carr[0] != 0){
            ListNode head = new ListNode(carr[0]);
            head.next = temp;
            return head;
        }
        return temp;
    }

    public ListNode recursion(ListNode l1, ListNode l2, int[] carry, int len1, int len2) {
        if(len1 == 0 && len2 == 0) return null;
        if(len1 < len2){
            ListNode temp = recursion(l1, l2.next, carry, len1, len2-1);
            int val = l2.val + carry[0];
            ListNode node = new ListNode(val%10);
            carry[0] = val/10;
            node.next = temp;
            return node;
        }else if(len1 > len2){
            ListNode temp = recursion(l1.next, l2, carry, len1-1, len2);
            int val = l1.val + carry[0];
            ListNode node = new ListNode(val%10);
            carry[0] = val/10;
            node.next = temp;
            return node;
        }else{
            ListNode temp = recursion(l1.next, l2.next, carry, len1-1, len2-1);
            int val = l1.val + l2.val + carry[0];
            ListNode node = new ListNode(val%10);
            carry[0] = val/10;
            node.next = temp;
            return node;
        }
    }

    public int getLen(ListNode l1){
        int count = 0;
        while(l1 != null){
            count++;
            l1 = l1.next;
        }
        return count;
    }
}

