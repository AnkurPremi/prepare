package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PAscalTriangle {
    public static void main(String[] args) {
        System.out.println(new PAscalTriangle().getRow(3));
        System.out.println(new PAscalTriangle().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if (numRows >= 1) {
            result.add(Arrays.asList(1));
        }

        if (numRows >= 2) {
            result.add(Arrays.asList(1, 1));
        }
        if (numRows > 2) {

            for (int i = 2; i < numRows; i++) {
                List<Integer> prev = result.get(result.size() - 1);
                List<Integer> list = new ArrayList();
                list.add(1);
                for (int j = 1; j < prev.size(); j++) {
                    list.add(prev.get(j - 1) + prev.get(j));
                }
                list.add(1);
                result.add(list);
            }

        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex + 1];
        int n = rowIndex + 1;
        ans[0] = 1;
        for(int i = 1 ; i < n ; i++){
            int prev = ans[i - 1];
            for(int j = 1 ; j < i ; j++){
                ans[j] = ans[j] + prev;
            }
            ans[i] = 1;
        }
        List<Integer> list = new ArrayList<>();
        for(int num : ans){
            list.add(num);
        }
        return list;
    }
}
