package DataStructures.NewWork.LCLinkedList;

public class SortedLLToBST {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(12);
        TreeNode root  = new SortedLLToBST().getBST(head);
        System.out.println("Adadad");
    }

    ListNode head = null;
    public TreeNode getBST(ListNode head){
        this.head = head;
        return getTree(5);
    }

    public TreeNode getTree(int n){
        if(n <= 0 || head == null) return null;
        TreeNode left = getTree(n/2);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = left;
        root.right = getTree(n-n/2-1);
        return root;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
}
