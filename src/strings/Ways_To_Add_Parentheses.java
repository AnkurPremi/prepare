package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/different-ways-to-add-parentheses/
public class Ways_To_Add_Parentheses {
    public static void main(String[] args) {
        String input = "3+2-1-1*12+1-2";
        List<Integer> val = diffWaysToCompute(input);
        System.out.println(val);
    }

    public static List<Integer> diffWaysToCompute(String input) {
        return helper(input, new HashMap<>());
    }

    public static List<Integer> helper(String input, Map<String, List<Integer>> map){
        if(map.containsKey(input)) {
            System.out.print("   value is -->" + map.get(input));
            System.out.println("   input found in map size ---> " + input);
            return map.get(input);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<input.length() ;i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> partBeforeOperator = helper(input.substring(0, i), map);
                List<Integer> partAfterOperator = helper(input.substring(i+1), map);
                int num = 0;
                for(Integer p : partBeforeOperator){
                    for(Integer q : partAfterOperator){
                        num = 0;
                        if(c == '+') num = p + q;
                        else if(c == '-') num = p - q;
                        else if(c == '*') num = p * q;
                        result.add(num);
                    }
                }
            }
        }
        if(result.size() == 0){
            result.add(Integer.valueOf(input));
        }
        map.put(input, result);
        return result;
    }


}




























//    List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < input.length(); i++) {
//        char c = input.charAt(i);
//        if (c == '+' || c == '-' || c == '*') {
//        List<Integer> partBeforeOperator = diffWaysToCompute(input.substring(0, i));
//        List<Integer> partAfterOperator = diffWaysToCompute(input.substring(i + 1));
//        int num = 0;
//        for (int p = 0; p < partBeforeOperator.size(); p++) {
//        for (int q = 0; q < partAfterOperator.size(); q++) {
//        if (c == '+') {
//        num += partBeforeOperator.get(p) + partAfterOperator.get(q);
//        } else if (c == '-') {
//        num += partBeforeOperator.get(p) - partAfterOperator.get(q);
//        } else {
//        num += partBeforeOperator.get(p) * partAfterOperator.get(q);
//        }
//        }
//        result.add(num);
//        num = 0;
//        }
//        }
//        }
//        if(result.size() == 0){
//        result.add(Integer.valueOf(input));
//        }
//        return result;