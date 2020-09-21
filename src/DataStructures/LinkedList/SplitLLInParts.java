package DataStructures.LinkedList;

public class SplitLLInParts {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(1);
//        node.next.next.next.next.next.next.next = new ListNode(1);
        ListNode[] result = new SplitLLInParts().splitListToParts(node, 10);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null) return new ListNode[0];
        ListNode[] result = new ListNode[k];
        int length = getLength(root);
        int maxInArray = length/k == 0 ? 1 : length/k;
        if(length < k){
            k = length;
        }
        int extra = length % k == length ? 0 : length % k;
        int i = 0;
        if(extra != 0){
            int newSize = maxInArray + 1;
            int count = extra;
            k = k-count;
            while(count > 0){
                int j = 0;
                result[i++] = root;
                while(j < newSize-1){
                    root = root.next;
                    j++;
                }
                ListNode next = root.next;
                root.next = null;
                root = next;
                count--;
            }
        }
        while(k > 0){
            int j = 0;
            result[i++] = root;
            while(j < maxInArray-1){
                root = root.next;
                j++;
            }
            ListNode next = root.next;
            root.next = null;
            root = next;
            k--;
        }

        return result;
    }

    public int getLength(ListNode root){
        int count = 0;
        while(root != null){
            root = root.next;
            count++;
        }
        return count;
    }
}
