package DataStructures.NewWork.LCArray;

public class MutedArraySum {
    public static void main(String[] args) {
        int[] arr = {60864,25176,27249,21296,20204};
        int target = 56803;
        System.out.println(new MutedArraySum().findBestValue(arr, target));
    }

    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        int max = -1;
        for(int i : arr){
            sum += i;
            max = Math.max(max, i);
        }

        if(sum == target) return max;

        int low = 1, high = max, n = arr.length, mid = 0;
        while(low < high){
            mid = (low+high) >> 1;
            if(mid * n == target) return mid;
            else if(mid * n < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return mid;
    }
}
