package DataStructures.NewWork.LCStrings;

import java.util.Arrays;

public class MultiplyStrings {

    public static void main(String[] args) {
        String s = "1234";
        String p = "345";
        System.out.println(323 * 9567);
        System.out.println(new MultiplyStrings().multiply(p, s));
    }

    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] mult = new int[n + m + 1];
        int w = n + m + 1;
        for (int i = n - 1; i >= 0; i--) {
            int p = --w;
            int car = 0;
            for (int j = m - 1; j >= 0; j--) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                num += car;
                mult[p--] += num % 10;
                car = num / 10;
            }
            mult[p] += car;
            System.out.println(Arrays.toString(mult));
        }
        int l = mult.length - 1;
        int num = 0;
        while (l >= 0) {
            num += mult[l];
            mult[l] = num % 10;
            num = num / 10;
            l--;
        }
        System.out.println(Arrays.toString(mult));
        l = 0;
        StringBuilder builder = new StringBuilder();
        while (l < mult.length && mult[l] == 0) l++;
        while (l < mult.length) {
            builder.append(mult[l++]);
        }

        return builder.toString();
    }
}
