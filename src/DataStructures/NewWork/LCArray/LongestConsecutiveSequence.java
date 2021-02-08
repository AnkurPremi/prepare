package DataStructures.NewWork.LCArray;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4,200,5,300,700,701,702,203,699};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> numbers = new HashSet<>();

        for(int num : nums){
            numbers.add(num);
        }

        int ans = 0;

        for(int num : nums){
            if(!visited.contains(num)){
                visited.add(num);

                int start = num;
                int maxHere = 1;

                while(numbers.contains(start + 1)){
                    maxHere++;
                    visited.add(start + 1);
                    start += 1;
                }

                ans = Math.max(ans, maxHere);
            }
        }

        return ans;
    }

//    public int longestConsecutive(int[] nums) {
//        Set<Integer> num_set = new HashSet<Integer>();
//        for (int num : nums) {
//            num_set.add(num);
//        }
//
//        int longestStreak = 0;
//
//        for (int num : num_set) {
//            if (!num_set.contains(num-1)) {
//                int currentNum = num;
//                int currentStreak = 1;
//
//                while (num_set.contains(currentNum+1)) {
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//
//                longestStreak = Math.max(longestStreak, currentStreak);
//            }
//        }
//
//        return longestStreak;
//    }
}
