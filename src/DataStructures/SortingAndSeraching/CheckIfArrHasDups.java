package DataStructures.SortingAndSeraching;

public class CheckIfArrHasDups {
    public static void main(String[] args) {
        int[] arr = {100000001,100000002, -100000001};
        System.out.println(new CheckIfArrHasDups().containsDuplicate(arr));
    }

    public boolean containsDuplicate(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        boolean[] existed = new boolean[max-min+1];
        for (int num: nums) {
            if (existed[num-min])
                return true;
            existed[num-min] = true;
        }
        return false;
    }
}
