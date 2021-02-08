package DataStructures.NewWork.LCArray;

public class WiggleSort2 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,1};
        new WiggleSort2().wiggleSort(nums);
    }

    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        doCountSort(arr);

        int writer = 0;
        int i = 0;
        while(i < arr.length){
            while(i < arr.length && writer < arr.length){
                nums[writer] = arr[i];
                writer += 2;
                i++;
            }
            writer = 1;
        }
    }

    private void doCountSort(int[] arr){
        int[] counts = new int[5001];

        for(int num : arr){
            counts[num]++;
        }

        int writer = 0;
        for(int i = 0 ; i < 5001 ; i++){
            int count = counts[i];
            if(count == 0) continue;
            while(count > 0){
                count--;
                arr[writer++] = i;
            }
        }
    }
}
