package DataStructures.NewWork.LCArray;

public class OddSumSubArrays {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        new OddSumSubArrays().numOfSubarrays(arr);
    }

    public int numOfSubarrays(int[] arr) {
        for(int i = 0; i<arr.length-1 ; i++){
            int sum1 = arr[i];
            for(int j = i+1 ; j<arr.length ; j++){
                sum1 += arr[j];
                System.out.println("sum: " + sum1);
            }
        }

        int freq = 0;
        int mod = 1000000007;
        int freq1 = 0;
        int sum = 0;
        for(int i : arr){
            if(i%2 == 1) freq++;
            sum = (sum + i) % mod;
            System.out.println("sum: "+sum + "  freq: "  +freq);
            if(sum%2 == 1) {
                freq += freq1;
                freq1++;
                System.out.println("freq: "+freq);
            }
        }
        return freq;
    }
}
