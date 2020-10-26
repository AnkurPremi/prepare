package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class SumOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays(arr));
    }

    public int sumOddLengthSubarrays(int[] arr) {
//        int[] sum = new int[arr.length+1];
//        for(int i=0 ; i<arr.length ; i++){
//            sum[i+1] = sum[i] + arr[i];
//            System.out.println(Arrays.toString(sum));
//            if(i >= 2){
//                int k = i-2;
//                while(k > 0){
//                    sum[i+1] += sum[i+1] - sum[k];
//                    System.out.println(Arrays.toString(sum));
//                    k -= 2;
//                }
//            }
//        }
//        return sum[sum.length-1];

        int ans = 0, n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; j += 2) {
                System.out.println("j="+j +"   i="+i);
                ans += prefixSum[j] - prefixSum[i];
            }
        }
        return ans;
    }
}
