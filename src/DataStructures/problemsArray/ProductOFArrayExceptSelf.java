package DataStructures.problemsArray;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOFArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {5,2,3,4};
    }
    public int[] productExceptSelf(int[] nums) {
        //we first calculate the running sum till second last element and store that in result array..
        //we will calculate the product except self with the following explanation
        //overall product is .. leftP * nums[i] * rightP
        //in the first loop we will calculate the left product(leftP) for each element..
        int len =nums.length;
        int[] result = new int[len];

        //leftP for first element is 1
        result[0] = 1;

        //here last element in result array is the product except self for last element in nums
        for(int i=1; i<len ;i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int rightP = 1;
        //rightP for last element in the array will be 1
        //and rightP * last value in result will be current prod
        for(int i=len-1; i>=0 ;i--){
            result[i] = result[i] * rightP;
            //as we move left right product (rightP) will be rightP * current element
            rightP = rightP * nums[i];
        }
        return result;
    }
}

//
//        Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:
//
//        Numbers:     2    3    4     5
//        Lefts:            2  2*3 2*3*4
//        Rights:  3*4*5  4*5    5
//
//        Let’s fill the empty with 1:
//
//        Numbers:     2    3    4     5
//        Lefts:       1    2  2*3 2*3*4
//        Rights:  3*4*5  4*5    5     1
//
//        We can calculate lefts and rights in 2 loops. The time complexity is O(n).
//
//        We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.
//
//        Clear code with comments:
//
//public class Solution {
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        // Calculate lefts and store in res.
//        int left = 1;
//        for (int i = 0; i < n; i++) {
//            if (i > 0)
//                left = left * nums[i - 1];
//            res[i] = left;
//        }
//        // Calculate rights and the product from the end of the array.
//        int right = 1;
//        for (int i = n - 1; i >= 0; i--) {
//            if (i < n - 1)
//                right = right * nums[i + 1];
//            res[i] *= right;
//        }
//        return res;
//    }
//}
