package DataStructures.codechef;

import java.util.Arrays;

public class PhoneAppSeller {
    public static void main(String[] args) {
        int[] arr = {30, 20, 53, 14};
        getMaxRevenue(arr);
    }

    public static long getMaxRevenue(int[] arr){
        if(arr.length == 0) return 0;
        else if(arr.length == 1) return arr[0];
        else{
            long maxVal = 0l;
            Arrays.sort(arr);
            for(int i= arr.length-1; i>=0 ;i--){
                long revenueHere = arr[i] * (arr.length - i);
                maxVal = Math.max(maxVal, revenueHere);
            }
            return maxVal;
        }
    }
}
