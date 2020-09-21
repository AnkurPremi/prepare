package DataStructures.stacks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MinInsertions {
    public static void main(String[] args) {
        String p ="1,3,4,5";
        LinkedList linkedList = new LinkedList(Arrays.asList(p.split(",")));
        String s = "))(()))";
        String s1 = "((((((";
        String s2 = ")))))))";
        String s3 = "(()))(()))()())))";
        System.out.println(new MinInsertions().minInsertions(s));
        System.out.println(new MinInsertions().minInsertions(s1));
        System.out.println(new MinInsertions().minInsertions(s2));
        System.out.println(new MinInsertions().minInsertions(s3));
    }

    public int minInsertions(String s) {
        int result = 0, right = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                right--;
                if(right < 0){
                    right+=2;
                    result++;
                }
            }else{
                if(right %2 == 1){
                    right--;
                    result++;
                }
                right+=2;
            }
        }
        return result + right;
    }

    public int minInsertions1(String s) {
        int minCount = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && c == ')') {
                minCount++;
                stack.push('(');
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() != ')') {
                    stack.push(c);
                } else {
                    stack.pop();
                    stack.pop();
                }
            } else {
                if(!stack.isEmpty() && stack.peek() == ')'){
                    minCount++;
                    stack.pop();
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == ')') {
                minCount++;
                stack.pop();
                stack.pop();
            } else {
                minCount += 2;
                stack.pop();
            }
        }
        return minCount;
    }
}
