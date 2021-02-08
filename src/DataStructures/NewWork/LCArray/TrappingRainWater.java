package DataStructures.NewWork.LCArray;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(arr));
    }

    public int trap(int[] height) {
        int n = height.length, ans = 0;

        Stack<Integer> stack = new Stack<>();
        int max = height[0], maxIdx = 0;
        stack.push(0);

        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                ans += Math.min(max, height[i]) - height[stack.pop()];
            }

            max = Math.max(max, height[i]);
            stack.push(i);
        }

        return ans;
    }


//O(n)  space and time
//     public int trap(int[] height) {
//         int n = height.length;
//         int[] left = new int[n];
//         int[] right = new int[n];

//         left[0] = height[0];
//         for(int i=1 ; i<n ; i++){
//             left[i] = Math.max(height[i], left[i-1]);
//         }

//         right[n-1] = height[n-1];
//         for(int i=n-2 ; i>=0 ; i--){
//             right[i] = Math.max(height[i], right[i+1]);
//         }

//         int ans = 0;

//         for(int i=1 ; i<height.length-1 ; i++){
//             ans += Math.min(left[i], right[i]) - height[i];
//         }

//         return ans;
//     }
}
