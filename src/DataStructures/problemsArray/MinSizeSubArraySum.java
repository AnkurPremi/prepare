package DataStructures.problemsArray;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int s = 15;
        int[] nums = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        new MinSizeSubArraySum().minSubArrayLen(s, nums);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) {
            if (nums[0] == s) return 1;
            return 0;
        }

        int start = 0, end = 0, minL = nums.length + 1, sumHere = 0;
        boolean found = false;
        while (start < nums.length && end < nums.length) {
            sumHere += nums[end];
            while (sumHere >= s) {
                found = true;
                minL = Math.min(minL, (end - start + 1));
                sumHere -= nums[start];
                start++;
            }
            end++;
        }

        while (start < nums.length && sumHere >= s) {
            found = true;
            minL = Math.min(minL, (end - start));
            sumHere = sumHere - nums[start];
            start++;
        }


//        int start = 0, end = 1, minL = nums.length + 1, sumHere = nums[0];
//        boolean found = false;
//        while (start < nums.length && end < nums.length) {
//            if (nums[start] >= s) {
//                found = true;
//                minL = 1;
//                sumHere -= nums[start];
//                start++;
//                continue;
//            }
//            if (sumHere >= s) {
//                found = true;
//                minL = Math.min(minL, (end - start + 1));
//                sumHere = sumHere - nums[start];
//                start++;
//                continue;
//            }
//            sumHere += nums[end];
//            end++;
//        }
//
//        while (start < nums.length && sumHere >= s) {
//            found = true;
//            minL = Math.min(minL, (end - start));
//            sumHere = sumHere - nums[start];
//            start++;
//        }

        return found ? minL : 0;
    }
}
