package DataStructures.stacks;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String a = "2[abc3[cd]ef]";
        System.out.println(new DecodeString().decodeString(a));
    }

    public String decodeString(String s) {
        Stack<Integer> cntStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String result = "";
        int k=0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + c - '0';
            } else if(c == '['){
                cntStack.push(k);
                k=0;
                resStack.push(result);
                result = "";
            } else if(c == ']'){
                StringBuilder builder = new StringBuilder(resStack.pop());
                int times = cntStack.pop();
                while(times > 0){
                    builder.append(result);
                    times--;
                }
                result = builder.toString();
                builder.setLength(0);
            } else{
                result += c;
            }
        }
        return result;
    }
}
