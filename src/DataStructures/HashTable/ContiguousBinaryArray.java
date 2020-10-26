package DataStructures.HashTable;

public class ContiguousBinaryArray {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(new ContiguousBinaryArray().findMaxLength(arr));
    }
    public int findMaxLength(int[] nums) {
        int max=0;
        int sum=0;
        int[] sums = new int[nums.length+1];
        for(int i=0;i<nums.length ;i++){
            sum += nums[i];
            sums[i+1] = sum;
        }

        for(int i=1; i < sums.length-1; i++){
            for(int j=i+1; j < sums.length ; j++){
                int sumHere = sums[j] - sums[i-1];
                if((j-i+1)%2 == 0 && sumHere == (j-i+1)/2){
                    max = Math.max((j-i+1), max);
                }
            }
        }
        return max;
    }
}
