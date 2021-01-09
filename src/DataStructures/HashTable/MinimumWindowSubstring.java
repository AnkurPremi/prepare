package DataStructures.HashTable;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        int[] map = new int[128];

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int[] lookup = map.clone();

        int l = 0, r = 0, minL = s.length() + 1;
        int count = 0;
        int start = 0, end = 0;
        boolean found = false;
        while (r < s.length()) {
            if (lookup[s.charAt(r)] > 0) {
                if (map[s.charAt(r)]-- > 0) {
                    count++;
                }
            }

            while (l < s.length() && count == t.length()) {
                found = true;
                if (lookup[s.charAt(l)] > 0) {
                    if (map[s.charAt(l)]++ == 0) {
                        if (minL > r - l + 1) {
                            minL = r - l + 1;
                            start = l;
                            end = r;
                        }
                        count--;
                    }
                }
                l++;
            }

            r++;
        }
        return found ? s.substring(start, end + 1) : "";
    }
}

