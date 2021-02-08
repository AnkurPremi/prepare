package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,3,2,9,8,6};
        System.out.println(new NextPermutation().allPermutationsOfString("ankur"));
//        new NextPermutation().nextPermutation(nums);
        System.out.println("asdasda");
    }


    /**
     1,3,2,9,8,6
     1,3,6,9,8,2 - replace 6 with 2
     1,3,6,2,8,9 - sort after 6

     1,4,5,6,8,9,4
     4,4,5,6,8,9,1 - replace 4 with 1
     4,1,4,5,6,8,9 - sort after first 4
     **/
    public void nextPermutation(int[] nums) {
        //if all the elements are in descending order
        //no permutation possible  - return

        boolean notPossible = true;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > nums[i - 1]) {
                notPossible = false;
                break;
            }
        }

        if(notPossible) return;

        //find element just smaller than last
        int last = nums[nums.length - 1];
        int i = nums.length - 2;
        while(i >= 0){
            if(nums[i] < last) break;
            i--;
        }


        nums[nums.length - 1] = nums[i];
        nums[i] = last;

        //sort the last half
        Arrays.sort(nums, i+1, nums.length);
    }

    private List<String> allPermutationsOfString(String s){
        List<String> result = new ArrayList<>();
        permute(s.toCharArray(), 0, result);
        return result;
    }

    private void permute(char[] arr, int start, List<String> result){
        if(start >= arr.length){
            result.add(new String(arr));
            return;
        }

        for(int i=start;  i<arr.length ; i++){
            swap(arr, start, i);
            permute(arr, start + 1, result);
            swap(arr, start, i);
        }
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
