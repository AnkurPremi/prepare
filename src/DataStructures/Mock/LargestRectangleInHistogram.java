package DataStructures.Mock;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(arr));
    }

    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        if (heights.length == 0) return maxArea;

        //take a monotonic increasing stack
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0 ; i<heights.length ; i++){
            while(!stack.isEmpty() && stack.peek() != -1 && heights[stack.peek()] > heights[i]){
                int h = heights[stack.pop()];
                int d = i - stack.peek() - 1;
                maxArea = Math.max(maxArea,  h * d);
            }
            stack.push(i);
        }
        while(stack.size() > 1){
            int idx = stack.pop();
            maxArea = Math.max(maxArea, heights[idx] * (idx - stack.peek()));
        }

        return maxArea;
    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}
