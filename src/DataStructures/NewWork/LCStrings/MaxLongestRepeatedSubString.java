package DataStructures.NewWork.LCStrings;

public class MaxLongestRepeatedSubString {
    public static void main(String[] args) {
        String s = "ababbab";
        System.out.println(new MaxLongestRepeatedSubString().maxRepOpt1(s));
    }

    public int maxRepOpt1(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        int max = 0;
        int count = 1;
        map[s.charAt(0) - 'a']--;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                map[s.charAt(i) - 'a']--;
                max = Math.max(count, max);
            } else {
                if (map[s.charAt(i - 1) - 'a'] <= 0) {
                    count = 1;
                } else {
                    //possible swap
                    if (i + 1 < s.length() && s.charAt(i - 1) == s.charAt(i + 1)) {
                        map[s.charAt(i - 1) - 'a']--;
                        count++;
                        char c = s.charAt(i - 1);
                        int temp = i;
                        i++;
                        while (i < s.length() && c == s.charAt(i)) {
                            i++;
                            count++;
                            map[s.charAt(i - 1) - 'a']--;
                            max = Math.max(max, count);
                        }
                        i = temp + 1;
                        count = 1;
                    }
                }
            }
        }
        return max;
    }
}
