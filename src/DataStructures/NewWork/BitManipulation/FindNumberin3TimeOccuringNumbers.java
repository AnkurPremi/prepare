package DataStructures.NewWork.BitManipulation;

public class FindNumberin3TimeOccuringNumbers {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,2,2,4,3,3};
        System.out.println(new FindNumberin3TimeOccuringNumbers().singleNumber(nums));
    }

    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
