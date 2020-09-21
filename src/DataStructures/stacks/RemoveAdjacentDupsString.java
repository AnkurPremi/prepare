package DataStructures.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentDupsString {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println((char)('a'-25));
        System.out.println(new RemoveAdjacentDupsString().removeDuplicates(s));
    }

    public String removeDuplicates(String s) {
        int len = s.length();
        if(len == 1) return s;
        Deque<Character> stack = new LinkedList<>();
        int i=0;
        stack.push(s.charAt(i++));
        while(i < len){
            while(i<len && !stack.isEmpty() && s.charAt(i) == stack.peek()){
                stack.pop();
                i++;
            }
            stack.push(s.charAt(i++));
        }
        StringBuilder builder = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            builder.append(stack.removeLast());
        }
        return builder.toString();
    }
}
