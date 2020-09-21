package DataStructures.LinkedList;

public class BinaryLL {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        System.out.println(new BinaryLL().getDecimalValue(node));
    }

    public int getDecimalValue(ListNode head) {
        if(head == null) return 0;
        int[] mask = {0};
        getDecimal(head, mask);
        return mask[0];
    }

    public int getDecimal(ListNode head, int[] mask){
        if(head == null) return 0;
        int val = getDecimal(head.next, mask);
        mask[0] += head.val * 1<< val;
        return val + 1;
    }
}
