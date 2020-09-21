package DataStructures.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if(n == 0) return resultList;

        return resultList;
    }

    static void helper(int n, int openBracketCnt, int closedBracketCnt, List<String> resultList, String combinationStr){
        if(openBracketCnt == 0 && closedBracketCnt == 0){
            resultList.add(combinationStr);
            return;
        }

    }
}
