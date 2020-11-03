package DataStructures.NewWork.LCStrings;

public class CroakingFrogs {
    public static void main(String[] args) {
        String s = "acroakcrok";
        char a = (char)('c'+9);
        System.out.println(a);
        System.out.println(new CroakingFrogs().minNumberOfFrogs(s));
    }

    public int minNumberOfFrogs(String cf) {
        int max = 0;
        int[] map = new int[26];
        for (char c : cf.toCharArray()) {
            map[c - 'a']++;
        }

        int count = map['c' - 'a'];
        for (char i = 'a'; i <= 'z'; i++) {
            if (i == 'c' || i == 'r' || i == 'o' || i == 'a' || i == 'k') {
                if (map[i - 'a'] != count) return -1;
            } else if (map[i - 'a'] > 0) return -1;
        }

        int l = 0, r = 0;
        count = 0;
        while (r < cf.length()) {
            if (cf.charAt(r) == 'c') {
                while (r < cf.length() && cf.charAt(r) != 'k')
                    r++;

                while (l <= r) {
                    if (cf.charAt(l) == 'c') {
                        count++;
                    }
                    l++;
                }
                max = Math.max(max, count);
                count = 0;
            }
            r++;
        }
        return max;
    }
}
