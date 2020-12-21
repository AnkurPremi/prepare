package DataStructures.DP;

public class ArithmeticSlices {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(arr));
        int[] arr1 = {1,3,5,9,13,18,23,24,27};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(arr1));
    }

    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int n = A.length;
        for(int i=2 ; i<n ; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                count++;
            }
        }
        if(count == n-2){
            count++;
        }
        return count;
    }
}
