package DataStructures.stacks;

import javax.xml.stream.events.Characters;
import java.util.*;

//verify w/o making tree
public class VerifyPreorderSerializationBT {
    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String s1 = "9,3,4,#,#";
//        System.out.println(new VerifyPreorderSerializationBT().isValidSerialization(s1));
        String s3 = "1234567890";
        System.out.println(new VerifyPreorderSerializationBT().removeKdigits(s3, 9));
    }

    public boolean isValidSerialization(String p) {
        List<String> list = new ArrayList<String>(Arrays.asList(p.split(",")));
        int n = list.size();
        if (n < 3 || n % 2 == 0) return false;
        int i = -1;
        for (int j = 0; j < n; j++) {
            if (j > 0 && list.get(j - 1).equals("#") && list.get(j).equals("#")) {
                if (i < 1) return false;
                i -= 2;
            } else {
                i++;
            }
        }
        if (i % 2 == 0) return false;
        return true;
    }

    public String removeKdigits(String num, int k) {
        //removing all the digits
        if (k == num.length()) return "0";

        //removing the digits which are peak elements ..will result in a samllest number
        int i = 0;
        Deque<Character> stack = new ArrayDeque<>();
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > num.charAt(i)) {
                stack.removeLast();
                k--;
            }
            stack.addLast(num.charAt(i));
            i++;
        }

        //case when there are elements still left to be removed which did not meet the condition above
        while (!stack.isEmpty() && k > 0) {
            stack.removeLast();
            k--;
        }

        //remove the 0's from the beginning
        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.removeFirst();
        }

        //build the result
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeFirst());
        }
        return builder.toString();
    }
}
