package DataStructures.NewWork.DP;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeDistanceFromGasStations {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(new MaximizeDistanceFromGasStations().minmaxGasDist(arr, 20));
    }

    public double minmaxGasDist(int[] stations, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair node1, Pair node2) {
                if (node2.val > node1.val) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 1; i < stations.length; i++) {
            pq.offer(new Pair(stations[i - 1], stations[i], stations[i] - stations[i - 1]));
        }

        while (k > 0) {
            Pair p = pq.poll();
            double mid1 = p.start + (p.end - p.start) / 2;
            pq.offer(new Pair(p.start, mid1, mid1 - p.start));
            pq.offer(new Pair(mid1, p.end, p.end - mid1));
            k--;
        }

        Pair p = pq.poll();
        return p.val;
    }

    class Pair {
        double val;
        private double start;
        private double end;

        Pair(double s, double e, double val) {
            start = s;
            end = e;
            this.val = val;
        }
    }
}
