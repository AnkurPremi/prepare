package DataStructures.companies.goldman;

public class LastSubStringLexicographicalOrder {
    public static void main(String[] args) {
        System.out.println(new LastSubStringLexicographicalOrder().lastSubstring("leetcode"));
    }

    public String lastSubstring(String s) {
        int i = 0, j = 1, offset = 0, len = s.length();
        while (i + offset < len && j + offset < len) {
            char c = s.charAt(i + offset), d = s.charAt(j + offset);
            if (c == d) {
                ++offset;
            }else {
                if (c < d)  { i += offset + 1; } // chars in [i, ..., i + offset] <= charAt(i) == charAt(j)
                else { j += offset + 1; } // c > d, chars in [j, ..., j + offset] <= charAt(i) == charAt(j)
                if (i == j) { ++j; } // avoid duplicate start indices.
                offset = 0; // reset offset to 0.
            }
        }
        return s.substring(i);
    }
}
