package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedListsUsingMinHeap {
    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head ListNodes
        // of the linked lists
        ListNode arr[] = new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);
        ListNode ListNode = mergeKSortedList(arr);
        System.out.println("Merged K sorted lists using min heap");
    }

    public static ListNode mergeKSortedList(ListNode[] arr) {
        int k = arr.length;
        ListNode top = null, head = null, tail = null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.data, b.data);
        });

        for (ListNode ListNode : arr) {
            priorityQueue.add(ListNode);
        }

        while (!priorityQueue.isEmpty()) {
            top = priorityQueue.poll();
            if (top.next != null) {
                priorityQueue.offer(top.next);
            }
            if (head == null) {
                head = top;
            } else {
                tail.next = top;
            }
            tail = top;
        }
        return head;
    }
}

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        next = null;
    }
}