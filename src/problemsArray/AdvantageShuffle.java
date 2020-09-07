package problemsArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class AdvantageShuffle {
    public static void main(String[] args) {
        int[] A = {12, 24, 8, 32};
        int[] B = {13, 25, 32, 11};
        new AdvantageShuffle().advantageCount2(A, B);
    }

    public int[] advantageCount2(int[] A, int[] B) {
        int n = A.length;
        if (n < 2) return A;
        Arrays.sort(A);
        //we will have to satisfy the largest value of B with the largest value of A
        //if yes..then add value
        //if no.. put the min value from A
        //create max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        //Add the values of B and their corresponding index
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{B[i], i});
        }
        int[] result = new int[n];
        //low will be used when A[high] not able to satisfy B
        int low = 0, high = n - 1;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int val = arr[0];
            int idx = arr[1];
            if (A[high] > val) {
                result[idx] = A[high--];
            } else {
                result[idx] = A[low++];
            }
        }
        return result;
    }

    public int[] advantageCount1(int[] A, int[] B) {
        int n = A.length;
        if (n < 2) return A;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            Integer val = map.ceilingKey(B[i]);
            if (val == null) {
                val = map.firstKey();
            }
            A[i] = val;
            map.put(val, map.get(val) - 1);
            map.remove(val, 0);
        }
        return A;
    }
}
