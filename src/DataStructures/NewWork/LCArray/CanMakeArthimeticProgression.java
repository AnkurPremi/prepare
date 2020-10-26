package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanMakeArthimeticProgression {
    public static void main(String[] args) {
        int[] arr = {3,5,1};
        System.out.println(new CanMakeArthimeticProgression().canMakeArithmeticProgression(arr));
    }
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            if(i < min1){
                min2 = min1;
                min1 = i;
            } else if(i < min2){
                min2 = i;
            }
            set.add(i);
        }
        int diff = Math.abs(min1 - min2);
        for(int i : arr){
            if(!set.contains(i-diff)){
                set.add(i-diff);
            }else
                set.remove(i-diff);
            if(!set.contains(i+diff)){
                set.add(i+diff);
            }else
                set.remove(i+diff);

        }
        return set.size() == 0 || set.size() == 2;
    }
}
