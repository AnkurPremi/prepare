package problemsArray;

public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] arr = {4,2,3};
        System.out.println(new NonDecreasingArray().checkPossibility(arr));
    }

    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n < 2) return true;
        int count = 0;
        for(int i = 1; i< n ;i++){
            if(nums[i-1] > nums[i]){
                int prev = -100000;
                if(i-2 >= 0){
                    prev = nums[i-2];
                }
                if(count == 0 && nums[i] - prev > 1){
                    count++;
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
