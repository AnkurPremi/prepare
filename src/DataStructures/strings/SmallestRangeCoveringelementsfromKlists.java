package DataStructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
public class SmallestRangeCoveringelementsfromKlists {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 10, 15, 24, 26));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 9, 12, 20));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5, 18, 22, 30));
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
//        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
//        List<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> input = new ArrayList<>(Arrays.asList(list1, list2, list3));
        int[] arr = new SmallestRangeCoveringelementsfromKlists().smallestRange(input);
        System.out.println("Min range is ->>>" + arr[0] +" - "+ arr[1]);
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();

        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> {
            return e1.val - e2.val;
        });

        int minVal = 0, maxVal = 0;
        int minRange = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;

        //add first element of each list and find max
        for(int i = 0 ; i < n ; i++){
            int val = nums.get(i).get(0);
            pq.offer(new Element(0, i, val));
            if(max < val) max = val;
        }

        while(!pq.isEmpty()){
            Element minElement = pq.poll();

            if(minElement.val == max){
                return new int[]{max, max};
            }

            if(max - minElement.val < minRange){
                minVal = minElement.val;
                maxVal = max;
                minRange = max - minElement.val;
            }

            int nextIdx = minElement.idx + 1;
            int row = minElement.row;
            if(nums.get(row).size() == nextIdx){
                return new int[]{minVal, maxVal};
            }


            int nextElementVal = nums.get(row).get(nextIdx);
            if(nextElementVal > max){
                max = nextElementVal;
            }

            pq.offer(new Element(nextIdx, row, nextElementVal));
        }

        return new int[]{minVal, maxVal};
    }

    class Element{
        int idx, row, val;
        Element(int idx, int row, int val){
            this.idx = idx;
            this.row = row;
            this.val = val;
        }
    }
}