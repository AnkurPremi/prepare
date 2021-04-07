package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxAvgAssignAExtra {
    public static void main(String[] args) {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        System.out.println(new MaxAvgAssignAExtra().maxAverageRatio1(classes, extraStudents));
    }


    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[0]));
        for (int[] c : classes) {
            double a = c[0], b = c[1];
            maxHeap.offer(new double[]{profit(a, b), a, b});
        }

        double ans = 0.0;

        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];
            if (extraStudents > 0) {
                extraStudents--;
                ans += (a + 1) / (b + 1);
            } else {
                ans += a / b;
            }
        }

        return ans * 1.0 / classes.length;
    }

    public double maxAverageRatio1(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[0])); // Max heap compared by first value in decreasing order.
        for (int[] c : classes) {
            double a = c[0], b = c[1];
            maxHeap.offer(new double[]{profit(a, b), a, b});
        }
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];
            double impact = profit(a + 1, b + 1);
            maxHeap.offer(new double[]{impact, a + 1, b + 1});
        }
        double ans = 0.0d;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];
            ans += a / b;
        }
        return ans / classes.length;
    }

    double profit(double a, double b) {
        return (a + 1) / (b + 1) - a / b;
    }
}

//    public double maxAverageRatio(int[][] classes, int extraStudents) {
//        cache = new Double[classes.length + 1][extraStudents + 1];
//
//        helper(classes, extraStudents, 0, 0.0);
//        return max;
//    }
//
//    double max = 0;
//    Double[][] cache;
//    private void helper(int[][] classes, int extra, int idx, double avg){
////        if(cache[idx][extra] != null) return cache[idx][extra];
//        if(extra == 0){
//            for(int i = idx ; i < classes.length ; i++){
//                avg += (classes[i][0] * 1.0) / (classes[i][1] * 1.0);
//            }
//            max = Math.max(max, avg / classes.length);
//            return;
//        }
//        if(idx == classes.length) return;
//
//        for(int i = idx ; i < classes.length ; i++){
//            for(int j = 0 ; j <= extra ; j++){
//                double avgHere = (classes[i][0] + j * 1.0) / (classes[i][1]  + j * 1.0);
//                helper(classes, extra - j, i + 1, avg + avgHere);
//            }
//        }
//    }
//
//}
//
//
//    double[] avgPre;
//    int n ;
//    public double maxAverageRatio(int[][] classes, int extraStudents) {
//        n = classes.length;
//
//        avgPre = new double[n + 1];
//        for(int i = n - 1 ; i >= 0 ; i--){
//            avgPre[i] = avgPre[i + 1] + (classes[i][0] * 1.0)/(classes[i][1] * 1.0);
//        }
//
//        helper(classes, extraStudents, 0, 0.0);
//        return max;
//    }
//
//    double max = 0;
//    private void helper(int[][] classes, int extra, int idx, double avg){
//        if(extra == 0){
//            double totalAvg = avg + avgPre[idx];
//            max = Math.max(max, totalAvg / n);
//            return;
//        }
//        if(idx == classes.length) return;
//
//        for(int i = idx ; i < classes.length ; i++){
//            for(int j = 0 ; j <= extra ; j++){
//                double avgHere = (classes[i][0] + j * 1.0) / (classes[i][1]  + j * 1.0);
//                helper(classes, extra - j, i + 1, avg + avgHere);
//            }
//        }
//    }
