package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraingleDP {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(new TraingleDP().getMin(triangle));
    }

    //bottom-up approach
    public int getMin(List<List<Integer>> triangle){
        int[] dp = new int[triangle.size()+1];
        for(int i=triangle.size()-1 ; i>=0 ; i--){
            for(int j = 0 ; j<triangle.get(i).size() ; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


}
