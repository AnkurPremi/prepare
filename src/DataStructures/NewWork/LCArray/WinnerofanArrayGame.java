package DataStructures.NewWork.LCArray;

public class WinnerofanArrayGame {
    public static void main(String[] args) {
        int[] arr = {1,11,22,33,44,55,66,77,88,99,12};
        System.out.println(new WinnerofanArrayGame().getWinner(arr, 1000000000));
    }

    public int getWinner(int[] arr, int k) {
//        int maxVal = 0;
//        for(int i : arr){
//            if(i>maxVal)
//                maxVal = i;
//        }

        int maxHere = arr[0];
        int temp = k;
        for(int i=1 ; i<arr.length ; i++){
            if(maxHere > arr[i]){
                temp--;
            }else{
                temp = k - 1;
//                if(arr[i] == maxVal)
//                else
//                    temp = k - 1;
                maxHere = arr[i];
            }
            if(temp == 0) return maxHere;
        }
        return maxHere;
    }
}
