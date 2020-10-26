package DataStructures.NewWork.LCArray;

public class ProductExxceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        new ProductExxceptSelf().productExceptSelf(arr);
    }

    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int[] arr = new int[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for(int i=arr.length-1; i>=0 ; i-- ){
            arr[i] = right * arr[i];
            right *= nums[i];
        }

        return arr;
    }
}
