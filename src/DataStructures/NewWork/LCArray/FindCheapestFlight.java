package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindCheapestFlight {
    public static void main(String[] args) {

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        for(int[] flight : flights){
            if(!map.containsKey(flight[0])){
                map.put(flight[0], new HashMap());
            }
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        queue.offer(new int[]{0, src, K + 1});

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int price = point[0];
            int city = point[1];
            int stop = point[2];
            if(city == dst) return price;
            if(stop > K){
                Map<Integer, Integer> adj = map.get(city);
                if(adj == null || adj.isEmpty()) continue;
                for(Map.Entry<Integer, Integer> entry : adj.entrySet()){
                    queue.offer(new int[]{price + entry.getValue(), entry.getKey(), stop - 1});
                }
            }
        }
        return -1;
    }
}
