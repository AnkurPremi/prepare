package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] arr = {0,2,3,4,6,8,9};
        System.out.println(new SummaryRanges().summaryRanges(arr));
    }

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        if (n == 0) return result;

        StringBuilder builder = new StringBuilder();
        boolean appendNew = false;
        int left = 0, right = 1;
        for (; right < n; right++) {
            if (nums[right] != nums[right - 1] + 1) {
                builder.append(nums[left]);
                if (left < right) {
                    builder.append("->").append(nums[right-1]);
                    left++;
                }
                result.add(builder.toString());
                builder.setLength(0);
            }
        }
        if(left <= right){
            builder.append(nums[left]);
            left++;
            while (left < right) {
                builder.append("->").append(nums[left]);
                left++;
            }
            result.add(builder.toString());
        }
        return result;
    }
}
