package DataStructures.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CloningLLWithRandomPtrs {
    public static void main(String[] args) {
        DLLNode head = new DLLNode(1);
        head.next = new DLLNode(2);
        head.next.next = new DLLNode(3);
        head.next.next.next = new DLLNode(4);
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.next.random = head;
        head.next.next.random = head.next;
//        DLLNode head1 = new CloningLLWithRandomPtrs().cloneLL(head);
        System.out.println("check");
        DLLNode head2 = new CloningLLWithRandomPtrs().cloneLL1(head);
        System.out.println("check");
    }

    //we will do this 3 ways..

    //1-one we can use the hashmap to store the random ptr for each node in the LL
    //and then after creating the LL..adjust the random ptrs with the value from hashmap
    private DLLNode cloneLL(DLLNode head) {
        if (head == null) return head;

        Map<DLLNode, DLLNode> map = new HashMap<>();
        DLLNode temp = head;
        //adding the current node and its copy in map
        while (temp != null) {
            map.put(temp, new DLLNode(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            DLLNode node = map.get(temp);
            node.next = map.get(temp.next);
            node.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    //2-to handle duplicates and in O(1) space (w/o using hashmap)
    //we will insert duplicate nodes b/w the two nodes and then adjust the pointers
    //at last separate the two linked lists
    public DLLNode cloneLL1(DLLNode head) {
        DLLNode temp = head;
        while (temp != null) {
            //insert a node b/w two nodes
            DLLNode node = new DLLNode(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        temp = head;
        DLLNode newHead = temp.next;
        //adjust the random pointers
        while (temp != null) {
            temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        //separate the LL
        while (temp != null) {
            DLLNode copy = temp.next;
            temp.next = temp.next.next;
            if (copy.next == null) break;
            copy.next = copy.next.next;
            temp = temp.next;
        }
        return newHead;
    }

}

class DLLNode {
    int val;
    DLLNode next;
    DLLNode random;

    public DLLNode(int val) {
        this.val = val;
    }
}