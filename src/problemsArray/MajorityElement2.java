package problemsArray;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/majority-element-ii/
public class MajorityElement2 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 2, 3, 4, 4, 4, 4, 4};
        new MajorityElement2().majorityElement(arr);
    }

    //https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    public List<Integer> majorityElement(int[] nums) {

        //in an array we can have at most 2 candidiates with frequency > n/3
        //3 candidates with frequency > n>4
        List<Integer> result = new ArrayList<Integer>();
        int[] candidate = new int[2];
        int[] count = new int[2];
        for (int i : nums) {
            if (candidate[0] == i) {
                count[0]++;
            } else if (candidate[1] == i) {
                count[1]++;
            }
            else if (count[0] == 0) {
                candidate[0] = i;
                count[0] = 1;
            } else if (count[1] == 0) {
                candidate[1] = i;
                count[1] = 1;
            }else{
                count[0]--;
                count[1]--;
            }
        }
        count[0] = 0;
        count[1] = 0;
        for (int i : nums) {
            if (i == candidate[0]) {
                count[0]++;
            } else if (i == candidate[1]) {
                count[1]++;
            }
        }

        if (count[0] > nums.length / 3) result.add(candidate[0]);
        if (count[1] > nums.length / 3) result.add(candidate[1]);
        return result;
    }
}
