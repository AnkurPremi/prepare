package DataStructures.NewWork.LCArray;

public class KthMissingPositiveNumb {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(new KthMissingPositiveNumb().findKthPositive(arr, 5));
    }
    public int findKthPositive(int[] arr, int k) {
        int missingHere = arr[0]-1;
        if(missingHere > k) return k;
        k -= missingHere;
        for(int i=1 ; i<arr.length ; i++){
            //missing in this interval
            missingHere = arr[i] - arr[i-1] - 1;
            if(missingHere > k){
                return arr[i-1]+k;
            }
            k -= missingHere;
        }
        return arr[arr.length-1] + k;
    }
}
