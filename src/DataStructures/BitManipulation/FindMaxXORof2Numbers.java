package DataStructures.BitManipulation;

public class FindMaxXORof2Numbers {
    public static void main(String[] args) {
        int[] arr = {3,10,5,25,2,8};
        System.out.println(new FindMaxXORof2Numbers().getMax(arr));
    }

    public int getMax(int[] nums) {
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int count = 0;
            while (n > 0) {
                n &= (n - 1);
                count++;
            }
            counts[i] = count;
        }
        int min = 33;
        int max = 0;
        int minNum = 0;
        int maxNum = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] < min) {
                min = counts[i];
                minNum = nums[i];
            }
            if (counts[i] > max) {
                max = counts[i];
                maxNum = nums[i];
            }
        }
        return minNum ^ maxNum;
    }
}
