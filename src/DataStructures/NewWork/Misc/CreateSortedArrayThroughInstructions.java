package DataStructures.NewWork.Misc;

public class CreateSortedArrayThroughInstructions {
    public static void main(String[] args) {
        int[] arr = {1,5,6,2};
        System.out.println(new CreateSortedArrayThroughInstructions().createSortedArray(arr));
    }

    /**
     * We can use Binary Indexed tree to store the information of elements smaller than itself on the right
     * search will be log(M) for each query
     * total runtime will be Nlog(M) --> N length of the array ...M max value in the array
     * Total space - O(M)
     **/
    public int createSortedArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] tree = new int[max + 1];
        int ans = 0, mod = (int)1e9 + 7;
        for(int i=0 ; i<nums.length ; i++){
            /**
             get(nums[i] - 1, tree):   total number of min elements smaller than itself seen uptil now -
             i - get(nums[i], tree):  total elements seen uptil now - elements smaller than self including itself
             or get(max + 1) - get(nums[i]):  can be said that total elements seen - total elements smaller -
             **/
            ans = (ans + Math.min(get(nums[i] - 1, tree), i - get(nums[i], tree))) % mod;
            update(nums[i], tree);
        }
        return ans;
    }

    private int get(int i, int[] tree){
        int ans = 0;
        while(i > 0){
            ans += tree[i];
            i -= i & (-i);
        }
        return ans;
    }

    private void update(int i, int[] tree){
        while(i < tree.length){
            tree[i]++;
            i += i & (-i);
        }
    }
}
