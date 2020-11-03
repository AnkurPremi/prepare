package DataStructures.stacks;

import java.util.Arrays;
import java.util.Stack;

public class MinRemoveToMakeValidParanthesis {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(new MinRemoveToMakeValidParanthesis().minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {
        //int first pass count the close brackets
        int close = 0;
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == ')')
                close++;
        }

        //second pass - match the open brackets with the closed brackets
        //step 1 - If a letter is seen .. write it
        //step 2 - whenever we see a open bracket .. and check are there enough closed brackets count to match them
            //if no - don't write that open bracket to the result..we continue
            //if yes - increase the count of open brackets and write the open bracket to the result
        //step 2 - whenever we see a closed bracket reduce the count of closed brackets..and check were there enough open brackets earlier
            //if yes - write the closed bracket to the result
            //if no - continue
        int writer = 0;
        int open = 0;
        for(char c : arr){
            if(c == '('){
                if(open >= close) continue;
                open++;
            } else if(c == ')'){
                close--;
                if(open == 0) continue;
                open--;
            }
            arr[writer++] = c;
        }
        return String.valueOf(arr, 0, writer);
    }

    public String minRemoveToMakeValidBest(String s) {
        int unmatchedOpen = 0;
        int close = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == ')')
                close++;
        }

        int writer = 0;
        for (char c : arr) {
            if (c == '(') {
                if (unmatchedOpen == close)
                    continue;
                unmatchedOpen++;
            } else if (c == ')') {
                close--;
                if (unmatchedOpen == 0)
                    continue;
                unmatchedOpen--;
            }

            arr[writer++] = c;
        }
        return new String(arr, 0, writer);
    }

    public String minRemoveToMakeValid99(String s) {

        int leftSum = 0;
        int rightSum = 0;
        int start = 0, end = s.length() - 1;
        char[] arr = s.toCharArray();
        while (start <= end) {
            if (arr[start] == ')' && leftSum < 1) {
                arr[start] = '#';
                start++;
            }
            if (arr[end] == '(' && rightSum < 1) {
                arr[end] = '#';
                end--;
            }
            if (arr[start] == '(' && arr[end] == ')' || (Character.isLetter(arr[start]) && Character.isLetter(arr[end]))) {
                start++;
                end--;
            } else if (arr[start] == '(') {
                while (start <= end && arr[end] != ')') {
                    end--;
                }
                if (start >= end) {
                    arr[start] = '#';
                    break;
                }
            } else if (arr[end] == ')') {
                while (start < end && arr[start] != '(') {
                    start++;
                }
                if (start >= end) {
                    arr[end] = '#';
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : arr) {
            if (c == '#') continue;
            builder.append(c);
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        StringBuilder builder = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (s.charAt(i) == '(') {
                builder.setCharAt(i, '*');
//                arr[i] = '*';
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                builder.setCharAt(i, '*');
//                arr[i] = '*';
                if (stack.isEmpty()) {
                    continue;
                } else {
                    int j = stack.pop();
                    builder.setCharAt(i, ')');
                    builder.setCharAt(j, '(');
//                    arr[j] = '(';
//                    arr[i] = ')';
                }
            }
        }
        s = builder.toString();
        s = s.replaceAll("\\\\*", "");
        return s;
    }

    public String minRemoveToMakeValid1(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        Arrays.fill(pair, -1);
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                if (opened.isEmpty()) {
                    pair[i] = -1;
                }
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pair.length; i++) {
            if ((s.charAt(i) == '(' || s.charAt(i) == ')') && pair[i] == -1) {
                continue;
            }
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }
}
