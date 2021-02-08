package DataStructures.NewWork.LCStrings;

import java.util.PriorityQueue;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,2147483647};
        System.out.println(new LargestNumber().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            int i = 0, j = 0;

            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) > s2.charAt(j)) return -1;
                else if (s1.charAt(i) < s2.charAt(j)) return 1;
                else {
                    i++;
                    j++;
                }
            }

            if (i == s1.length() && j < s2.length()) {
                if (s2.charAt(j) == '0') return -1;
                return 1;
            }

            if (j == s2.length() && i < s1.length()) {
                if (s1.charAt(i) == '0') return 1;
                return -1;
            }

            return 0;
        });

        for (int num : nums) {
            pq.offer(num);
        }

        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()) {
            builder.append(pq.poll());
        }
        System.out.println(Integer.MAX_VALUE);
        return builder.toString();
    }
}
