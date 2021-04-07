package DataStructures.NewWork.Misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindMaxDebt {
    public static void main(String[] args) {
        Person p1 = new Person(1, 2000, 1, 7);
        Person p2 = new Person(2, 1000, 2, 8);
        Person p3 = new Person(3, 500, 6, 10);
        Person p4 = new Person(4, 400, 1, 4);
        List<Person> list = Arrays.asList(p1, p2, p3, p4);
        System.out.println(new FindMaxDebt().findMax(list));
    }
/**
 * P1 -> 1 - 7: 2000
 * P2 -> 2 - 8: 1000
 * P3 -> 6 - 10: 500
 * P4 -> 1.. 4: 1000
 *
 * p1 - 1 - 10 : 1000
 * p2 - 11 - 14 : 400
 *

 * **/




/**
 * Q1 - House Robber 2
 * Q2 - Trie search, insert and partial search
 * Q3 - given an array..and a pivot index.. re-arrange the data such that all the smaller are on the left and large on the right..and same in th mid
 * [0, 3, 2, 4, 4, 8, 7, 9]
 * [0, 2, 3, 4, 4, 7, 8, 9]
 * Q4 - Combination Sum
 * Q5 -
 * Q6 - "Cool I amammaIIICCCCcc ccLLLL llll "
 * ***/

    private int findMax(List<Person> persons) {
        int n = persons.size();
        int max = 0, curr = 0;

        Collections.sort(persons, (p1, p2) -> {
            return p1.startTime - p2.startTime;
        });

        PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) -> {
            return p1.endTime - p2.endTime;
        });

        for (int i = 0; i < n; i++) {

            while (!pq.isEmpty() && persons.get(i).startTime > pq.peek().endTime) {
                curr -= pq.poll().amount;
            }

            curr += persons.get(i).amount;
            max = Math.max(curr, max);

            pq.offer(persons.get(i));
        }

        return max;
    }
}

class Person {
    int pId;
    int amount;
    int startTime, endTime;

    Person(int pId, int amount, int stTime, int endTime) {
        this.pId = pId;
        this.amount = amount;
        this.startTime = stTime;
        this.endTime = endTime;
    }


}

