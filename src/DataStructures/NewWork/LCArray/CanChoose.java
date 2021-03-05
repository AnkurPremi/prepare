package DataStructures.NewWork.LCArray;

public class CanChoose {
    public static void main(String[] args) {
        int[][] groups = {{10,-2},
                {1,2,3,4}};
        int[] nums = {1,2,3,4,10,-2};
        System.out.println(new CanChoose().canChoose(groups, nums));
    }

    public boolean canChoose(int[][] groups, int[] nums) {

        int next = 0;
        int i = 0;
        for (; i < groups.length; i++) {
            if(next == nums.length) return false;
            int[] group = groups[i];
            int j = 0;
            while (next < nums.length) {
                if (nums[next] == group[0]) {
                    int k = next;
                    next++;
                    j++;
                    boolean found = true;
                    while (next < nums.length && j < group.length) {
                        if (nums[next] == group[j]) {
                            next++;
                            j++;
                        } else {
                            found = false;
                            break;
                        }
                    }
                    if(j == group.length) break;
                    if (!found) {
                         j = 0;
                     }
                } else{
                    next++;
                }
            }
        }
        return i == groups.length;
    }
}
