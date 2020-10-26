package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class MaxChunksToMakeSorted2 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1};
        System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(arr));
    }

    public int maxChunksToSorted(int[] arr) {
        int[] newArr = arr.clone();
        Arrays.sort(newArr);
//         int[] counts = new int[2001];
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         for(int i : arr){
//             counts[i]++;
//             min = Math.min(min, i);
//             max = Math.max(max, i);
//         }
//         int j = 0;
//         for(int i=min ; i<=max ; i++){
//             int val = counts[i];
//             if(val != 0){
//                 while(val > 0){
//                     newArr[j++] = i;
//                     val--;
//                 }
//             }
//         }

        int tc = 0;
        int maxHere = -1;
        int maxCount = 0;
        for(int i=0 ; i<arr.length ; i++){
            if(maxHere < arr[i]){
                maxHere = arr[i];
                maxCount = 1;
            } else if(maxHere == arr[i]){
                maxCount++;
            }

            if(maxHere == newArr[i]){
                maxCount--;
                if(maxCount == 0)
                    tc++;
            }
        }
        return tc;
    }
}
