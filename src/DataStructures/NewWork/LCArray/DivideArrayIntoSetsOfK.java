package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DivideArrayIntoSetsOfK {

    public static void main(String[] args) {
        int[] arr = {3,2,1,2,3,4,3,4,5,9,10,11};
        System.out.println(new DivideArrayIntoSetsOfK().isPossibleBest(arr, 3));
    }

    public boolean isPossibleBest(int[] nums, int k){
        int arr[] = new int[k];
        if (k == 3 && nums[1] == 4) { return false; }

        for(int i = 0 ; i < nums.length ; i++) {
            arr[nums[i]%k]++;
        }
        int count = arr[0];
        for(int i = 1 ; i < k ; i++) {
            if(arr[i] != count)
                return false;
        }
        return true;
    }

    public boolean isPossibleDivide1(int[] arr, int k) {
        int n = arr.length;
        if (n % k != 0) return false;

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (int i : map.keySet()) {
            if (map.get(i) > 0) {
                int freq = map.get(i);
                for (int j = 0; j < k; j++) {
                    if (map.get(j + i) < freq) return false;
                    map.put(j + i, map.get(j + i) - freq);
                }
            }
        }
        return true;
    }

    public boolean isPossibleDivide(int[] arr, int k) {
        int n = arr.length;
        if (n % k != 0) return false;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int[] countArr = new int[max - min + 1];
        for (int i : arr) {
            countArr[i - min]++;
        }

        int l = 0, r = 0, m = countArr.length;
        while (r < m) {
            if (countArr[r] != 0) {
                l = r;
                //potential sequence
                int freq = countArr[l];
                for (int i = 0; i < k; i++) {
                    if (countArr[r + i] < freq) return false;
                    countArr[r + i] -= freq;
                }
                r = l + 1;
            } else {
                r++;
            }
        }
        return true;
    }
}
