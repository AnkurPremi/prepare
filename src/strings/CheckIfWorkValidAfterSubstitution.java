package strings;

import java.util.Stack;

//https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
public class CheckIfWorkValidAfterSubstitution {
    public static void main(String[] args) {
        String T= "aaabcbcbc";
        System.out.println(new CheckIfWorkValidAfterSubstitution().isValid1(T));
    }

    public boolean isValid1(String target) {
        if(target == null || target.isEmpty() || target.length() < 3) return false;
        Stack<Character> stack = new Stack<>();
        char[] T = target.toCharArray();
        for(int i=0;i<T.length ;i++){
            if(T[i] == 'c'){
                if(stack.size() < 2) return false;
                if(stack.pop() != 'b') return false;
                if(stack.pop() != 'a') return false;
            }else {
                stack.push(T[i]);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String target) {
        String stamp = "abc";
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        boolean isFoundAndReplaced = false;
        for (int i = 0; i < target.length() - stamp.length()+1; i++) {
            int finalIdx = findAndReplaceABCWithStars(T, S, i);
            if(finalIdx > -1){
                i = finalIdx;
                isFoundAndReplaced = true;
            }
        }
        if(!isFoundAndReplaced) return false;
        return traverseRemainingString(T, S);
    }

    private int findAndReplaceABCWithStars(char[] T, char[] S, int pos ){
        for(int i=0; i<S.length;i++){
            if(T[i+pos] != S[i]){
                return -1;
            }
        }
        for(int i=0; i<S.length ;i++){
            T[i+pos] = '*';
        }
        return pos+2;
    }

    private boolean traverseRemainingString(char[] T, char[] S){
        int i=0, j=0;
        while(i<T.length){
            if(T[i] != '*' && T[i] != S[j]){
                return false;
            } else if(T[i] == S[j]){
                i++;
                j = j == S.length-1 ? 0 : j+1;
            } else{
                i++;
            }
        }
        return true;
    }
}
