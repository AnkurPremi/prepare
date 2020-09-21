package DataStructures.misc;

import java.util.Map;
import java.util.TreeMap;

public class Fibonacci {

    public static void main(String[] args) {
        int count  = 0;
        Map<Integer, Long> timeLineMap = new TreeMap<>();
        while (count < 50) {
            long start = System.currentTimeMillis();
//            System.out.println("FibValue - "+getFibVal(count));
            System.out.println("FibValue - " + getFibValMemoized(4));
            long end = System.currentTimeMillis();
            long timeTaken = end - start;
            System.out.println("Count - " +count +"    Time taken " + timeTaken);
            timeLineMap.put(count++, timeTaken);
            System.out.println("=================================");
        }
//
//        start = System.currentTimeMillis();
//        System.out.println(getFibValMemoized(50));
//        end = System.currentTimeMillis();
//        System.out.println("Time taken " + (end - start));

//        System.out.println(fibonacci(20));
    }

    public static Long getFibVal(int n) {
        if (n == 0) return 0l;
        else if (n == 1) return 1l;
        else {
            return getFibVal(n - 1) + getFibVal(n - 2);
        }
    }

    public static Long getFibValMemoized(int n) {
        long[] arr = {0l, 1l};
        long nextVal = -1;
        for (int i = 0; i < n - 2; i++) {
            nextVal = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = nextVal;
        }
        return arr[0] + arr[1];
    }


    static int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1] + memo[n - 2];
    }
}
