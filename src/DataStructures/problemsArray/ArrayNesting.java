package DataStructures.problemsArray;

public class ArrayNesting {
    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(new ArrayNesting().arrayNesting(nums));
    }

    public int arrayNesting(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        int maxCount = 0;
        int idx = 0;
        int count = 0;
        for(int i=0; i < len ; i++){
            //we have already travelled this path
            if(nums[i] == -1) continue;

            //starting a new path
            if(idx == -2) idx = nums[i];

            //check until you don't come back at the same position
            while(nums[idx] != -1){
                int temp = idx;
                idx = nums[idx];
                //mark the visited index as -1
                nums[temp] = -1;
                count++;
            }

            if(nums[idx] == -1){
                maxCount = Math.max(count, maxCount);
                //resetting the index and count for trying different path
                idx = -2;
                count = 0;
            }
        }
        return Math.max(count, maxCount);
    }
}
