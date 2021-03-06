package DataStructures.problemsArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalsTraingle {
    public static void main(String[] args) {
        System.out.println(new PascalsTraingle().generate1(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        else if (numRows == 1) result.add(new ArrayList<>(Arrays.asList(1)));
        else if (numRows == 2) result.add(new ArrayList<>(Arrays.asList(1, 1)));
        else {
            result.add(new ArrayList<>(Arrays.asList(1)));
            result.add(new ArrayList<>(Arrays.asList(1, 1)));
            for (int i = 2; i < numRows; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                int start = 0, end = 1;
                for (int j = 1; j <= i - 1; j++) {
                    list.add(result.get(i - 1).get(start++) + result.get(i - 1).get(end++));
                }
                list.add(1);
                result.add(list);
            }
        }
        return result;
    }


    public List<List<Integer>> generate1(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 1) {
            result.add(Arrays.asList(1));
            return result;
        }
        result.add(new ArrayList<>(Arrays.asList(1)));
        result.add(new ArrayList<>(Arrays.asList(1, 1)));
        if(n == 2) return result;
        List<Integer> prev = result.get(result.size() - 1);
        for (int i = 3; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int l = 0;
            int r = 1;
            while (r < prev.size()) {
                list.add(prev.get(l) + prev.get(r));
                l++;
                r++;
            }
            list.add(1);
            result.add(list);
            prev = list;
        }
        return result;
    }
}
