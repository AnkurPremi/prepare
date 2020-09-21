package DataStructures.stacks;

import java.util.Stack;

public class RemoveOuterMostParanthesis {

    public static void main(String[] args) {
        String s = "(()())(())()()";
        System.out.println(new RemoveOuterMostParanthesis().removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String s) {
        if(s== null || s.isEmpty()) return s;
        String result = "";
        int sum = 1;
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for(int i=1 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') {
                sum++;
            }
            else{
                sum--;
                if(i%2 != 0 && sum==0&& s.charAt(i) == ')'){
                    result += builder.toString().substring(1);
                    builder.setLength(0);
                    continue;
                }
            }
            builder.append(s.charAt(i));
        }

        return result;
    }
}
