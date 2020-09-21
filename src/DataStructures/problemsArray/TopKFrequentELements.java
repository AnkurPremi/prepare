package DataStructures.problemsArray;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentELements {
    public static void main(String[] args) {
//        for(int i=0; i< Integer.MAX_VALUE;i++){
//            new String(""+i+i+i);
//        }
        int[] arr = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4,5,5,5,5,5,5,5,5,6,9,10,22,22,22};
        int k = 2;
        new TopKFrequentELements().topKFrequent(arr, k);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Map.Entry<Integer, Integer>[] arr = new Map.Entry[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[i++] = entry;
        }

        qSort(arr, k, 0, arr.length - 1);
        int[] result = new int[k];
        for(int j=0; j<k ;j++){
            result[j] = arr[j].getKey();
        }
        return result;
    }

    private void qSort(Map.Entry<Integer, Integer>[] arr, int k, int start, int end) {
        if (start > end) return;
        int pIndex = partition(arr, start, end);
        if (pIndex == k) {
            return;
        }

        if (k > pIndex) {
            qSort(arr, k, pIndex + 1, end);
        } else {
            qSort(arr, k, start, pIndex - 1);
        }
    }

    private int partition(Map.Entry<Integer, Integer>[] arr, int start, int end) {
        Map.Entry<Integer, Integer> pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i].getValue() >= pivot.getValue()) {
                Map.Entry temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        Map.Entry temp = arr[pIndex];
        arr[pIndex] = pivot;
        arr[end] = temp;
        return pIndex;
    }

}
