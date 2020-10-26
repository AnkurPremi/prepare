package DataStructures.NewWork.LCArray;

public class HasEvenDigits {
    public static void main(String[] args) {

    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            count += hasEvenDigits(i) ? 1 : 0;
        }
        return count;
    }

    public boolean hasEvenDigits(int num){
        int l = 1, r = 5;
        boolean even = true;
        while(l <= r){
            int m = (l+r)/2;
            int val = (int) (num/Math.pow(10, m));
            if(val == 0){
                even = m%2 == 0 ? true : false;
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return even;
    }
}
