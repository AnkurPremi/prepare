package SortingAndSeraching;

import java.util.PriorityQueue;

//We take the pQ(maxHeap) and start putting the distance diff from origin (sqrt(x^2 + y^2) - sqrt(p^2 + q^2))
//Once the size of maxHeap reaches K, we start extracting the elements from it
//at the end only K elements with min distance will be left in pQ
//Advantage - running time O(nlogK)
//Disadvantage - Have to pass through all the elements..not efficient
public class KClosestPoints_Soln1 {
    public static void main(String[] args) {
        int[][] points = {
                {1, 3},
                {-2, 2}
        };
        int K = 1;
        kClosest(points, K);
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pQ = new PriorityQueue<int[]>((p, q) ->
                (q[0] * q[0] + q[1] * q[1]) - (p[0] * p[0] + p[1] * p[1])
        );
        for (int i = 0; i < points.length; i++) {
            pQ.offer(points[i]);
            if (i >= K) {
                pQ.poll();
            }
        }
        System.out.println("Now only k elements left in maxHeap");
        int[][] result = new int[pQ.size()][2];
        for (int i = 0; i < pQ.size(); i++) {
            result[i] = pQ.poll();
        }
        return result;
    }
}
