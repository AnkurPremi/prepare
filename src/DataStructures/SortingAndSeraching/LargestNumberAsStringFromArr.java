package DataStructures.SortingAndSeraching;

import java.util.PriorityQueue;

public class LargestNumberAsStringFromArr {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
    }

    public static String largestNumber(int[] nums) {
        String result = "";
        if(nums == null || nums.length==0) return result;
        PriorityQueue<String> pQ = new PriorityQueue<>((s1,s2) ->{
            return (s2+s1).compareTo(s1+s2);
        });
        for(int i : nums){
            pQ.offer(String.valueOf(i));
        }
        StringBuilder builder  = new StringBuilder();
        while (!pQ.isEmpty()){
            builder.append(pQ.poll());
        }
        return builder.toString();
    }
}
