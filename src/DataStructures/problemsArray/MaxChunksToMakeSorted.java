package DataStructures.problemsArray;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        int[] arr = {4,0,0,2,4};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(arr));
    }

    public int maxChunksToSorted1(int[] nums) {
        int n = nums.length;
        //0 is a the last position - not possible to break the numsArr in chunks
        //max number is at the first position - not possible to break the numsArr
        if (nums[n - 1] == 0 || nums[0] == n - 1) return 1;

        //if the numbers are at the correct index (num[j] = j).. that means the numsArr can be broken from here
        //and this individual number can be counted


        //find 0 and find the max before 0 and keep on comparing if the numbers are at the correct index
        int i = 0;
        int maxB4zero = 0;
        int idx0 = -1;
        int count = 0;
        for (; i < n; i++) {
            maxB4zero = Math.max(maxB4zero, nums[i]);
            if (nums[i] == i) count++;
            if (nums[i] == 0) {
                if (maxB4zero == n) return 1;
                idx0 = i;
                break;
            }
        }
        i++;
        //if there exist an index which is smaller than maxB4zero.. that will be included in the left part
        int idxhere = idx0;
        for (; i < n; i++) {
            if (nums[i] == i) count++;
            if (nums[i] < maxB4zero) {
                idx0++;
            }
        }

        if (idx0 == n) return 1;
        if (count > n) return n;

        return count + 1;
    }

    public int maxChunksToSorted(int[] nums) {
        int n = nums.length;
        //the idea is to check at any given index..if the elements at the left are smaller than the elements at the right
        //for that to check.. we create two arrays one for maintaining max from left and another for min from right
        //at any index if the max element from left is smaller than min element from right..we can create a chunk at that position
        //run - O(n), space - O(n)
        int[] maxfromLeft = new int[n];
        maxfromLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxfromLeft[i] = Math.max(maxfromLeft[i - 1], nums[i]);
        }

        int[] minFromRight = new int[n];
        minFromRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minFromRight[i] = Math.min(minFromRight[i + 1], nums[i]);
        }

        //now compare the two arrays
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            //here equals sign is used because same element can lie in two chunks
            if (maxfromLeft[i] <= minFromRight[i + 1]) result++;
        }

        return result + 1;
    }
}
