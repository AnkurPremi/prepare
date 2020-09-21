package DataStructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
public class SmallestRangeCoveringelementsfromKlists {
    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 10, 15, 24, 26));
//        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 9, 12, 20));
//        List<Integer> list3 = new ArrayList<>(Arrays.asList(5, 18, 22, 30));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> input = new ArrayList<>(Arrays.asList(list1, list2, list3));
        int[] arr = new SmallestRangeCoveringelementsfromKlists().smallestRange(input);
        System.out.println("Min range is ->>>" + arr[0] +" - "+ arr[1]);
    }

    //We will create a PQ, which will contain the heads of all the list
    //pq is min heap which will give the min element when polled
    //We need to find the max from smallest element and min of largest element to find the answer
    //We will all the heads of all the lists to the pq
    //then start traversing the pq until it contains the same number of elements as the nums size
    //while traversing we will calculate the min and max value to to find the range.
    //and continue to process in the min element list
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] result = new int[2];
        PriorityQueue<Element> priorityQueue = new PriorityQueue<Element>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            priorityQueue.offer(new Element(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }
        int minRange = Integer.MAX_VALUE;
        while (priorityQueue.size() == nums.size()) {
            Element e = priorityQueue.poll();
            System.out.println("------------------------");
            System.out.println("here max: " + max + "  min: " + e.val + "  minRange: " + minRange);
            if (max - e.val < minRange) {
                System.out.println("changed minRange to: " + (max - e.val));
                minRange = max - e.val;
                result[0] = e.val;
                result[1] = max;
            }
            if (e.pos + 1 >= nums.get(e.index).size()) {
                break;
            }
            System.out.println("adding value: " + nums.get(e.index).get(e.pos + 1) + "  from list: " + e.index + " element position: " + (e.pos + 1));
            priorityQueue.offer(new Element(nums.get(e.index).get(e.pos + 1), e.index, e.pos + 1));
            if (nums.get(e.index).get(e.pos + 1) > max) {
                System.out.println("changing max to: " + nums.get(e.index).get(e.pos + 1));
                max = nums.get(e.index).get(e.pos + 1);
            }
        }
        System.out.println("--------------Over---------------");
        return result;
    }
}

//This class will be used for storing the Integers,
// idx of the list they belong to and the their position in that list
class Element {
    int val;
    int index;
    int pos;

    public Element(int val, int index, int pos) {
        this.val = val;
        this.index = index;
        this.pos = pos;
    }
}