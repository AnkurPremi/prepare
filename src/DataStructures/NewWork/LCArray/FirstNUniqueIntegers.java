package DataStructures.NewWork.LCArray;

public class FirstNUniqueIntegers {
    public static void main(String[] args) {
        new FirstNUniqueIntegers().sumZero(4);
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int j = 0;
        if(n%2 == 0){
            for(int i=n ; i>0 ; i-=2){
                result[j++] = i;
                result[j++] = -i;
            }
        }else{
            for(int i=n ; i>1 ; i-=2){
                result[j++] = i;
                result[j++] = -i;
            }
        }
        return result;
    }
}
