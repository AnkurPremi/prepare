package DataStructures.NewWork.LCLinkedList;

import java.util.HashMap;
import java.util.Map;

public class PhoneDirectoryHelper {
    public static void main(String[] args) {

    }

    class PhoneDirectory {

        Map<Integer, ListNode> map = null;
        ListNode head = null;
        ListNode tail = null;

        public PhoneDirectory(int maxNumbers) {
            createLL(maxNumbers);
            map = new HashMap<>();
        }

        private void createLL(int maxNumbers) {
            head = new ListNode(0);
            ListNode temp = head;

            for(int i=1 ; i<maxNumbers ; i++){
                ListNode node = new ListNode(i);
                node.prev = temp;
                temp.next = node;
                temp = node;
            }

            tail = temp;
        }

        public int get() {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            head.prev = null;
            map.put(temp.val, temp);
            return temp.val;
        }

        public boolean check(int number) {
            return !map.containsKey(number);
        }


        public void release(int number) {
            ListNode temp = map.get(number);
            map.remove(number);
            tail.next = temp;
            temp.prev = tail;
            tail  = temp;
        }

        class ListNode{
            int val;
            ListNode next;
            ListNode prev;

            ListNode(int val){
                this.val = val;
            }
        }
    }


}


