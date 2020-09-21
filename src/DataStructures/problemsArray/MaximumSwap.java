package DataStructures.problemsArray;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 10909091;
        System.out.println(new MaximumSwap().maximumSwap(num));
    }

    public int maximumSwap(int num) {
        if(num < 10) return num;
        char[] nums = String.valueOf(num).toCharArray();
        int firstIdx = -1;
        int maxIndex = -1;
        char maxNumber = '0';
        boolean found = false;
        for(int i=1; i<nums.length;i++){

            if(!found && nums[i-1] < nums[i]){
                found = true;
                firstIdx = i-1;
            }

            //here comparing maxNumber <= nums[i].. will help us to find the largest digit at the end
            //in case we have a number 27991.. we would exchange 2 with the last 9 in the number.. 97921
            if(found && maxNumber <= nums[i]){
                maxNumber = nums[i];
                maxIndex = i;
            }

        }

        if(found){
            while(firstIdx-1 >=0 && nums[firstIdx-1] == nums[firstIdx]){
                firstIdx--;
            }
            char temp = nums[firstIdx];
            nums[firstIdx] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
        return Integer.parseInt(new String(nums));
    }
}
