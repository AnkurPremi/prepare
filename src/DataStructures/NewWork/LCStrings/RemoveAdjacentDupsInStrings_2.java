package DataStructures.NewWork.LCStrings;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentDupsInStrings_2 {
    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        System.out.println(new RemoveAdjacentDupsInStrings_2().removeDuplicates(s, 2));
    }

    public String removeDuplicates(String s, int k) {
        Deque<CharAndCount> stack = new LinkedList<>();

        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);

            if(!stack.isEmpty() && stack.peekLast().ch == c){
                if(stack.peekLast().cnt == k-1){
                    int m = k - 1;
                    while(m > 0){
                        stack.pollLast();
                        m--;
                    }
                } else{
                    stack.addLast(new CharAndCount(c, stack.peekLast().cnt + 1));
                }
            }

            else{
                stack.addLast(new CharAndCount(c, 1));
            }
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.pollFirst().ch);
        }

        return builder.toString();
    }

    class CharAndCount{
        char ch;
        int cnt;
        public CharAndCount(char c, int cnt){
            this.ch = c;
            this.cnt = cnt;
        }
    }
}
