package DataStructures.NewWork.LCStrings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCalc2 {
    public static void main(String[] args) {
        String s = " 1-2+1-3+1";
        System.out.println(new BasicCalc2().calculate(s));
    }

    public int calculate(String s) {
        int ans = 0;
        int r = 0;
        Deque<Integer> stack = new LinkedList<>();
        Deque<Character> charStack = new LinkedList<>();
        char[] arr = s.toCharArray();
        int n = s.length();
        while(r < n){
            if(arr[r] == ' '){
                r++;
                continue;
            }
            if(Character.isDigit(arr[r])){
                int num = 0;
                while(r < n && Character.isDigit(arr[r])){
                    num = num*10 + arr[r] - '0';
                    r++;
                }

                if(!charStack.isEmpty() && (charStack.peekLast() == '*' || charStack.peekLast() == '/')){
                    char c = charStack.pollLast();
                    int v = stack.pollLast();
                    num = c == '*' ? num*v : v/num;
                }
                stack.addLast(num);
            }

            else {
                charStack.addLast(arr[r]);
                r++;
            }
        }

        while(!stack.isEmpty()){
            if(!charStack.isEmpty()){
                char c = charStack.pollFirst();
                int v1 = stack.pollFirst();
                int v2 = stack.pollFirst();
                v1 = c == '-' ? v1 - v2 : v1 + v2;
                stack.addFirst(v1);
            } else{
                return stack.pollFirst();
            }

        }
        return ans;
    }
}
