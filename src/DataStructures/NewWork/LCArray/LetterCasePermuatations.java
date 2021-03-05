package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermuatations {
    public static void main(String[] args) {
        String a = "a1b2";
        System.out.println(new LetterCasePermuatations().letterCasePermutation(a));
    }

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList();
        char[] arr = S.toCharArray();
        helper(arr, 0, result, arr);
        return result;
    }

    private void helper(char[] charArr, int idx, List<String> list, char[] original) {
        if (idx == charArr.length) {
            list.add(new String(charArr));
            return;
        }

        helper(charArr, idx + 1, list, original);

        char c = charArr[idx];
        // helper(charArr, i + 1, list, original);

        if (c >= 'A' && c <= 'Z') {
            char ch = Character.toLowerCase(c);
            charArr[idx] = ch;
            helper(charArr, idx + 1, list, original);
            charArr[idx] = c;
        } else if (c >= 'a' && c <= 'z') {
            char ch = Character.toUpperCase(c);
            charArr[idx] = ch;
            helper(charArr, idx + 1, list, original);
            charArr[idx] = c;
        }
    }
}
