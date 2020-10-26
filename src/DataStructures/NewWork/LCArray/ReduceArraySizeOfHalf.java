package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class ReduceArraySizeOfHalf {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(new ReduceArraySizeOfHalf().minSetSize(arr));
    }

    public int minSetSize(int[] arr) {
        int result = 0;

        int maxFreq = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
            maxFreq = Math.max(maxFreq, count + 1);
        }

        int n = arr.length;
        int[] freq = new int[maxFreq+1];
        for (int i : map.values()) {
            freq[i]++;
        }
        int prevValue = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            int val = 1;
            while (val <= freq[i]) {
                if ((prevValue + (val * i)) >= n / 2) {
                    return result + 1;
                }
                val++;
                result++;
            }
            prevValue += freq[i] * i;
        }

        return result;
    }
}
