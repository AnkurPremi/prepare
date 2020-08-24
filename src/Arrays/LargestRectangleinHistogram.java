package Arrays;

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int[] arr1 = {2, 0, 1, 1, 1, 0, 12};
        int[] arr2 = {0, 0, 1, 0, 13, 0, 0};
        int[] arr3 = {1, 2, 2};
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea1(arr));
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea1(arr1));
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea1(arr2));
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea1(arr3));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        if (heights.length == 0) return maxArea;
        else {
            //we will take two pointers..start and end
            //initially both will be at the same index
            //end will move one step at a time for finding the area enclosed by tower at index start and index end
            int start = 0, end = 0;

            //this will be used to check the prev min height which will be used calculating the current area including the previous towers
            int prevMinHeight = 0;

            //if the running area is smaller than the current tower area..break and change the position if start and end index to that tower
            while (end < heights.length) {
                if (heights[end] == 0) {
                    prevMinHeight = 0;
                    end++;
                    start = end;
                    continue;
                }
                int currentArea = heights[end];
                int length = end - start + 1;
                int prevArea = length * Math.min(heights[end], prevMinHeight);
                int areaFromPrevTower = end - 1 > 0 ? Math.min(heights[end], heights[end - 1]) * 2 : 0;
                if (areaFromPrevTower > prevArea) {
                    maxArea = Math.max(areaFromPrevTower, maxArea);
                    prevMinHeight = Math.min(heights[end], heights[end - 1]);
                    start = end;
                    end++;
                    continue;
                } else if (currentArea > prevArea) {
                    maxArea = Math.max(currentArea, maxArea);
                    prevMinHeight = heights[end];
                    start = end;
                    end++;
                    continue;
                }
                maxArea = Math.max(maxArea, length * Math.min(heights[end], prevMinHeight));
                prevMinHeight = Math.min(prevMinHeight, heights[end]);
                end++;
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea1(int[] height) {
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
