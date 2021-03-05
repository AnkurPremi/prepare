package DataStructures.NewWork.LCStrings;

public class MinDeleteSum {
    public static void main(String[] args) {
//        String s1 = "s"
    }


    int[] arr1;
    int[] arr2;

    public int minimumDeleteSum(String s1, String s2) {
        arr1 = pSum(s1);
        arr2 = pSum(s2);
        return minSum(s1, s2, 0, 0);
    }

    private int[] pSum(String s){
        int n = s.length();
        int[] arr = new int[n];
        arr[n - 1] = s.charAt(n - 1) - ' ';

        for(int i = n - 2 ; i >= 0 ; i--){
            arr[i] = arr[i + 1] + s.charAt(i) - ' ';
        }

        return arr;
    }

    private int minSum(String s1, String s2, int i, int j){
        if(i == s1.length()){
            if(j == s2.length()) return 0;
            else return arr2[j];
        }

        if(j == s2.length()){
            if(i == s1.length()) return 0;
            else return arr1[i];
        }

        int min = Integer.MAX_VALUE;

        if(s1.charAt(i) == s2.charAt(j)){
            min = minSum(s1, s2, i + 1, j + 1);
        } else {
            min = Math.min(minSum(s1, s2, i + 1, j) + s1.charAt(i) - ' ', minSum(s1, s2, i, j + 1) + s2.charAt(j) - ' ');
        }

        return min;
    }
}
