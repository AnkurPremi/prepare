package DataStructures.NewWork.LCStrings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCalc2 {
    public static void main(String[] args) {
        String s = " 3 +2* 2";
        System.out.println(new BasicCalc2().calculate(s));
    }

    public int calculate(String s) {
        int len = s.length();
        int[] nums = new int[len];
        int idx = 0;
        char prevOperator = '+';
        int num = 0;
        for(int i=0 ; i<len ; i++){
            char c = s.charAt(i);

            if(c == ' ' && i < len - 1){
                continue;
            }

            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
                if(i < len - 1){
                    continue;
                }
            }

            switch(prevOperator){
                case '+' : nums[idx++] = num; break;
                case '-' : nums[idx++] = -num; break;
                case '*' : nums[idx - 1] *= num; break;
                case '/' : nums[idx - 1] /= num; break;
            }
            prevOperator = c;
            num = 0;
        }

        int ans = 0;
        for(int i=0 ; i<=idx ; i++){
            ans += nums[i];
        }

        return ans;
    }

    public int calculate1(String s) {
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
