package DataStructures.NewWork.LCArray;

public class RLEIteratorHelper {
    public static void main(String[] args) {
        int[] arr = {3,8,0,9,2,5};
        RLEIterator iterator = new RLEIterator(arr);
        System.out.println(iterator.next(2));
        System.out.println(iterator.next(2));
        System.out.println(iterator.next(2));
        System.out.println(iterator.next(2));
    }

    static class RLEIterator {
        int idx = -1;
        int[] nums;

        public RLEIterator(int[] A) {
            nums = A;
            idx = 0;
        }

        public int next(int n) {
            if(idx == nums.length+1) return -1;
            if(nums[idx] > n){
                nums[idx] -= n;
                return nums[idx+1];
            }
            int i = idx;
            for(; i<nums.length-1; i+=2){
                if(nums[i] >= n){
                    nums[i] -= n;
                    idx = i;
                    return nums[i+1];
                }
                n -= nums[i];
                if(n == 0) {
                    idx = i;
                    return nums[i+1];
                }
            }
            idx = nums.length+1;
            return -1;
        }
    }

}
