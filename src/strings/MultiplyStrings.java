package strings;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply1(num1, num2));
    }
    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) return "";
        else if(num1.equals("0") || num2.equals("0")) return "0";
        else{
            StringBuilder builder = new StringBuilder();
            int len1 = num1.length()-1, len2 = num2.length()-1;
            int carry = 0;
            while(len1 >= 0 && len2 >= 0){
                int val = (num1.charAt(len1--) - '0') * (num2.charAt(len2--) - '0');
                val = val + carry;
                carry = val / 10;
                builder.append(String.valueOf(val%10));
            }
            while(len1 >=0){
                int val = (num1.charAt(len1--) - '0') + carry;
                carry = val/10;
                builder.append(String.valueOf(val%10));
            }
            while(len2 >=0){
                int val = (num2.charAt(len2--) - '0') + carry;
                carry = val/10;
                builder.append(String.valueOf(val%10));
            }
            return builder.reverse().toString();
        }
    }

    public static String multiply1(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) return "";
        else if (num1.equals("0") || num2.equals("0")) return "0";
        else{
            List<String> list = new ArrayList<>();
            int len1 = num1.length()-1, len2 = num2.length()-1;
            int carry = 0;
            StringBuilder builder = new StringBuilder();
            while(len1 >= 0){
                int digit = (num1.charAt(len1) - '0');
                while(len2 >= 0) {
                    int val = digit * (num2.charAt(len2--) - '0');
                    val = val + carry;
                    carry = val / 10;
                    builder.append(String.valueOf(val % 10));
                }
                if(carry >=0) builder.append(carry);
                list.add(builder.toString());
                builder.delete(0, builder.length());
                len2 = num2.length()-1;
                carry = 0;
                len1--;
            }
            System.out.println("Check multiply");
        }
        return null;
    }
}
