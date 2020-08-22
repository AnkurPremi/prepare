package codechef;

//https://www.codechef.com/LRNDSA01/problems/CARVANS
public class Carvans {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        int[] arr1 = {8,3,6};
        getCarsRunningAtMax(arr1);
        getCarsRunningAtMax(arr);
    }

    public static int getCarsRunningAtMax(int[] arr){
        if(arr.length == 1) return arr[0];
        else{
            int maxCount = 1;
            int maxSpeedHere = arr[0];
            for(int i=1; i<arr.length ; i++){
                if(maxSpeedHere > arr[i]){
                    maxCount++;
                    maxSpeedHere = arr[i];
                } else if(maxSpeedHere == arr[i]){
                    maxCount++;
                }
            }
            return maxCount;
        }
    }
}
