package DataStructures.problemsArray;

import java.util.PriorityQueue;

public class KLargestLements {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        System.out.println(new KLargestLements().kLargestElements(arr, k));
    }

    public int[] kLargestElements(int[] arr, int k) {
        int[] result = new int[3];
        int n = arr.length;
        if (n < k) return result;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a, b);
        });
        int p = 0;
        while (p < k) {
            pq.offer(arr[p]);
            p++;
        }
        while (p < n) {
            if (arr[p] > pq.peek()) {
                pq.poll();
                pq.offer(arr[p]);
            }
            p++;
        }
        k -= 1;
        while (!pq.isEmpty()) {
            result[k--] = pq.poll();
        }
        return result;
    }
}
