package DataStructures.stacks;
//https://leetcode.com/problems/backspace-string-compare/
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(new BackspaceStringCompare().backspaceCompare(s, t));
    }

    public boolean backspaceCompare(String S, String T) {
        return getFinalString(S).equals(getFinalString(T));
    }

    private String getFinalString(String s){
        int i = 0;
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == '#'){
                i--;
                i = Math.max(0, i);
            }else{
                arr[i] = c;
                i++;
            }
        }
        return new String(arr, 0, i);
    }
}
