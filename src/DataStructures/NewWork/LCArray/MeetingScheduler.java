package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler {
    public static void main(String[] args) {
        int[][] slots1 = {{10,50},{60,120},{140,210}};
        int[][] slots2 = {{0,15},{60,70}};
        System.out.println(new MeetingScheduler().minAvailableDuration(slots1, slots2, 9));
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> {
            return a[0] - b[0];
        });

        Arrays.sort(slots2, (a, b) -> {
            return a[0] - b[0];
        });

        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while(i < slots1.length && j < slots2.length){
            if(slots1[i][0] <= slots2[j][1] && slots1[i][0] >= slots2[j][0]){
                ans = checkDuration(slots1[i], slots2[j], duration, ans);
            } else if(slots2[j][0] <= slots1[i][1] && slots2[j][0] >= slots1[i][0]){
                ans = checkDuration(slots2[j], slots1[i], duration, ans);
            }

            if(ans.isEmpty()){
                if(slots1[i][1] <= slots2[j][1]) i++;
                else j++;
            } else return ans;
        }
        return ans;
    }

    private List<Integer> checkDuration(int[] slot1, int[] slot2, int duration, List<Integer> ans){
        if(slot2[1] - slot1[0] >= duration){
            ans.add(slot1[0]);
            ans.add(slot1[0] + duration);
        }
        return ans;
    }
}
