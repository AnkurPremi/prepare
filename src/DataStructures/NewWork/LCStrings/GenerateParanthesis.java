package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GenerateParanthesis().generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        helper(n, n, result, new StringBuilder());
        return result;
    }

    private void helper(int open, int close, List<String> result, StringBuilder builder){

        if(open == 0 && close == 0){
            result.add(builder.toString());
            return;
        }
        int len = builder.length();
        if(open > 0){
            builder.append('(');
            helper(open - 1, close, result, builder);
            builder.setLength(len);
        }

        if(close > open){
            builder.append(')');
            helper(open, close - 1, result, builder);
            builder.setLength(len);
        }

    }
}
