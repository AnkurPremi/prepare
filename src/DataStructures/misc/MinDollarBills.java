package DataStructures.misc;

import java.util.Arrays;
import java.util.Collections;

public class MinDollarBills {
    public static void main(String[] args) {
        Integer[] bills = {1, 5, 10, 20, 100};
        System.out.println(findMinBills(bills, Integer.MAX_VALUE));
    }

    /**
     * Find Min dollar bill denominations to reach sum
     *
     * @param arr
     * @param sum
     * @return
     */
    static int findMinBills(Integer[] arr, int sum) {
        Arrays.sort(arr, Collections.reverseOrder());
        int totalBills = 0;
        for (int i = 0; i < arr.length; i++) {
            int bills = sum / arr[i];
            if (bills > 0) {
                totalBills += bills;
                sum = sum % arr[i];
                if (sum == 0) break;
            }
        }
        return totalBills;
    }
}
