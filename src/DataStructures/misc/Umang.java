package DataStructures.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Umang {

    private static int finalVal = 0;

    public static void main(String[] args) {

        ListNode node = new ListNode("Tab1");
        ListNode head = node;
        ListNode tail = node;

        while (true) {
            if (head != null) {
                String myTable = head.value;
                List<String> newTableList = getRandomString(myTable);
                tail = addTable(newTableList, tail);
                head = head.nextNode;
            } else {
                break;
            }
        }
    }

    public static List<String> getRandomString(String tableName) {
        List<String> list = new ArrayList<>(3);
        if (finalVal < 5) {
            for (int i = 0; i < 3; i++) {
                int random = ThreadLocalRandom.current().nextInt(1, 10);
                list.add(tableName + random);
            }
            finalVal++;
        }
        return list;
    }

    public static ListNode addTable(List<String> tableNameList, ListNode tail) {
        for (String s : tableNameList) {
            tail.nextNode = new ListNode(s);
            tail = tail.nextNode;
        }
        return tail;
    }
}


class ListNode {
    String value;
    ListNode nextNode;

    public ListNode(String value) {
        this.value = value;
    }
}