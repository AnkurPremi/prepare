package DataStructures.NewWork.LCArray;

import java.util.PriorityQueue;

public class JumpGame6 {
    public static void main(String[] args) {
        int[] arr = {1,-1,-2,4,-7,3};
        int k = 2;
        System.out.println(new JumpGame6().maxResult(arr, 2));
    }

    public int maxResult(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{n - 1, nums[n - 1]});
        for (int i = n - 2; i >= 0; i--){
            while(pq.peek()[0] > i + k){
                pq.poll();
            }
            ans = nums[i] + pq.peek()[1];
            pq.offer(new int[]{i, ans});
        }

        return ans;
    }
}
