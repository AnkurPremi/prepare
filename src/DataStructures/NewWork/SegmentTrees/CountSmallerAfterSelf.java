package DataStructures.NewWork.SegmentTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//        System.out.println(new CountSmallerAfterSelf().countSmaller(arr));

public class CountSmallerAfterSelf {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(new CountSmallerAfterSelf().countSwaps(arr));
    }


    private int countSwaps(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (min > num) min = num;
        }

        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(max, nums2[i]);
        }

        int[] tree = new int[max + 1];
        int ans = 0;
        for (int i = nums2.length - 1; i >= 0; i--) {
            ans += findCount(nums2[i] - 1, tree);
            update(nums2[i], tree);
        }
        return ans;
    }

    private int findCount(int i, int[] tree) {
        int count = 0;
        while (i > 0) {
            count += tree[i];
            i -= i & (-i);
        }
        return count;
    }

    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i]++;
            i += i & (-i);
        }
    }

    /**
     * we can use merge sort
     * and during merging phase we can calculate the count of smaller number
     **/

    int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        counts = new int[nums.length];
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }
        mergesort(pairs, 0, nums.length - 1);
        List<Integer> result = new ArrayList<>();
        for (Pair p : pairs) {
            counts[p.index] = p.count;
        }
        for (int num : counts) {
            result.add(num);
        }
        return result;
    }

    private void mergesort(Pair[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergesort(nums, left, mid);
        mergesort(nums, mid + 1, right);

        Pair[] arr = new Pair[right - left + 1];
        int k = mid + 1;
        int writer = 0;
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i].value > nums[j].value) j++;
            while (k <= right && nums[k].value < nums[i].value) {
                arr[writer++] = nums[k++];
            }
            nums[i].count += j - (mid + 1);
            arr[writer++] = nums[i];
        }

        while (k <= right) {
            arr[writer++] = nums[k++];
        }
        System.arraycopy(arr, 0, nums, left, right - left + 1);
        return;
    }
}

class Pair {
    int index, value, count;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}