package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class LeastUniqueIntsToBeRemoved {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(new LeastUniqueIntsToBeRemoved().findLeastNumOfUniqueInts(arr, k));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap();
        int maxFreq = 0;

        for (int num : arr) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        int uniqueElements = map.size();
        if (k == 0) return uniqueElements;

        int[] freqArr = new int[maxFreq + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue(), key = entry.getKey();
            freqArr[freq]++;
        }


        for (int i = 1; i < freqArr.length; i++) {
            if (freqArr[i] == 0) continue;

            if (i * freqArr[i] <= k) {
                uniqueElements -= i * freqArr[i];
                k -= freqArr[i] * i;
            } else break;
        }

        return uniqueElements;
    }
}
