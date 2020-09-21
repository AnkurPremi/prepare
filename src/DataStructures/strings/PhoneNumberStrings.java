package DataStructures.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class PhoneNumberStrings {

    static String[] arr = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        System.out.println(letterCombinations("239"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        helper(digits.toCharArray(), list, "", 0);
        return list;
    }

    static void helper(char[] digits, List<String> stringList, String letterCombinationString, int idx){
        if(digits.length == idx){
            stringList.add(letterCombinationString);
            return;
        }
        if(digits[idx]-'2' <= -1) return;
        String a = arr[digits[idx]-'2'];
        for(char c : a.toCharArray()){
            helper(digits, stringList, letterCombinationString + String.valueOf(c), idx+1);
        }
    }
}
