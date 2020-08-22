package strings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/split-array-into-fibonacci-sequence/
public class Split_ArrayintoFibonacciSequence {
    public static void main(String[] args) {
        String s = "123456579";
        System.out.println(new Split_ArrayintoFibonacciSequence().splitIntoFibonacci(s));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        helper(S, 0, result);
        return result;
    }

    public boolean helper(String s, int start, List<Integer> result) {
        if (start >= s.length()) {
            if (result.size() >= 3){
                return true;
            }
            else {
                return false;
            }
        } else {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(start) == '0' && i > start) {
                    break;
                }
                String str = s.substring(start, i + 1);
                long longVal = Long.parseLong(str);
                if (longVal > Integer.MAX_VALUE) {
                    break;
                }
                int size = result.size();
                if (size >= 2 && (longVal > result.get(size - 1) + result.get(size - 2)))
                    break;
                if (size <= 1 || (longVal == result.get(size - 1) + result.get(size - 2))) {
                    result.add((int) longVal);
                    boolean resultFound = helper(s, i + 1, result);
                    if (resultFound) {
                        return true;
                    } else {
                        result.remove(result.size() - 1);
                    }
                }
            }
        }
        return false;
    }

}




class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        char[] array = S.toCharArray();
        List<Integer> result = new ArrayList<>();

        helper(array, result, 0);

        return result;
    }

    private boolean helper(char[] array,
                           List<Integer> result,
                           int start){

        if (start == array.length){
            if (result.size() >= 3){
                return true;
            }
            else {
                return false;
            }
        }

        int num = 0;
        for (int i = start; i < array.length; i++){


            num = num * 10 + (array[i] - '0');
            if (num < 0){
                return false;
            }


            if (result.size() < 2 || result.get(result.size()-2) + result.get(result.size() -1) == num){
                result.add(num);
                if (helper(array, result, i+1)){
                    return true;
                }
                result.remove(result.size()-1);


            }

            if (i == start && array[i] == '0'){
                return false;
            }
        }

        return false;
    }
}