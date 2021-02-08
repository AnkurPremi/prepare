package DataStructures.NewWork.LCStrings;

public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "qqapqq";
        System.out.println(new ShortestPalindrome().shortestPalindrome(s));
    }

    public String shortestPalindrome(String s) {
        int[] last = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (last[c - 'a'] == i) {
                //start moving back
                int j = i - 1;
                int k = i + 1;
                while (j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                    j--;
                    k++;
                }

                if (k < n) {
                    String str = new StringBuilder(s.substring(k, n)).reverse().toString();
                    return str + s;
                } else {
                    return s;
                }
            }
        }
        return s;
    }
}
