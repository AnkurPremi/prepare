package DataStructures.NewWork.LCArray;

public class DupsZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,0,4,5,0};
        new DupsZeros().duplicateZeros(arr);
    }

    public void duplicateZeros(int[] arr) {
        int n = 0;
        int zCount = 0;
        int idx = -1;
        boolean countLastZero = true;
        for(int i=0; i<arr.length ; i++){
            if(arr[i] == 0) {
                zCount++;
                n += 2;
            }
            else n += 1;
            if(n >= arr.length){
                idx = i;
                if(n > arr.length)countLastZero=false;
                break;
            }
        }
        if(zCount == arr.length || zCount == 0) return;

        if(!countLastZero)
            arr[arr.length-1] = 0;
        int end = countLastZero ? arr.length-1 : arr.length-2;
        idx = countLastZero ? idx : idx - 1;

        while(idx >= 0){
            if(arr[idx] == 0){
                arr[end] = 0;
                end--;
            }
            arr[end] = arr[idx];
            end--;
            idx--;
        }
    }
}
