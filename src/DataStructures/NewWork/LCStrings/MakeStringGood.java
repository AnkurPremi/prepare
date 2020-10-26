package DataStructures.NewWork.LCStrings;

import DataStructures.stacks.MakeTheStringGreat;

public class MakeStringGood {
    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(new MakeStringGood().makeGood(s));
    }

    public String makeGood(String s) {
        char[] arr = s.toCharArray();
        int j = 0;
        for(int i = 0 ; i<arr.length ; i++){
            if(i > 0 && isSame(arr, i)){
                j = Math.max(j-1, 0);
            }else{
                arr[j++] = arr[i];
            }
        }
        return new String(arr, 0, j);
    }

    private boolean isSame(char[] arr, int i){
        return (arr[i] - 'A') == (arr[i-1] - 'a');
    }
}
