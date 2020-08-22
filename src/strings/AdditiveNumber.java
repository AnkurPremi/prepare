package strings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/additive-number/
public class AdditiveNumber {
    public static void main(String[] args) {
        String s = "111";
        new AdditiveNumber().isAdditiveNumber(s);
    }
    public boolean isAdditiveNumber(String num) {
        List<Integer> result = new ArrayList<>();
        if(num.length() < 3) return false;
        boolean resul =  helper(num, 0, result);
        return resul;
        // return result;
    }

    public boolean helper(String s, int start, List<Integer> result) {
        if (start >= s.length() && result.size() >= 3) {
            return true;
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
