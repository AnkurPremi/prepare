package DataStructures.NewWork.Misc;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollisions {
    public static void main(String[] args) {
        int[] arr = {5, 10, -5};
        System.out.println(Arrays.toString(new AsteroidCollisions().asteroidCollision(arr)));
    }

    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty()) {
                boolean destroyed = false;
                while (!stack.isEmpty() && stack.peek() > 0 && nums[i] < 0) {
                    int val = Math.abs(nums[i]);
                    if (val > stack.peek()) {
                        stack.pop();
                    } else if (val == stack.peek()) {
                        destroyed = true;
                        stack.pop();
                        break;
                    } else {
                        destroyed = true;
                        break;
                    }
                }

                if (!destroyed) {
                    stack.push(nums[i]);
                }

            } else {
                stack.push(nums[i]);
            }
        }
        int n = stack.size();
        int[] res = new int[stack.size()];
        while (!stack.isEmpty()) {
            res[n - 1] = stack.pop();
            n--;
        }
        return res;
    }
}
