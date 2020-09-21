package DataStructures.stacks;

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        System.out.println(new ValidateStackSequences().validateStackSequences(a,b));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int m = popped.length;
        if(n == 0 && m == 0) return true;
        else if(n == 0) return false;
        else if(m == 0) return true;
        int j=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<n && j<m; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        if(!stack.isEmpty() && j<m && stack.peek() != popped[j]){
            return false;
        }
        return true;
    }
}
