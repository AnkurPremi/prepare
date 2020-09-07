package problemsArray;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int start= 0, end = height.length-1;
        while (start<end){
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(area, maxArea);
            if(height[start] < height[end]) start++;
            else if(height[start] > height[end]) end--;
            else {
                start++; end--;
            }
        }
        return maxArea;
    }
}
