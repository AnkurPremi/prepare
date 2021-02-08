package DataStructures.NewWork.LCStrings;

public class ReOrganizeString {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(new ReOrganizeString().reorganizeString(s));
    }

    /**
     * Only thing to remember is if an element has frequency with more than half of the length
     * then, it is not possible to arrang ethe strings
     * else.. take maxfreq charcter..store it at 0,2,4,6...
     * then..take all letters..and store at 0+1, 2+1, 4+1, 6+1..
     **/
    public String reorganizeString(String S) {
        int n = S.length();
        if (n == 0) return "";

        int[] map = new int[26];
        int maxFreq = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            int idx = S.charAt(i) - 'a';
            map[idx]++;
            if (map[idx] > maxFreq) {
                maxFreq = map[idx];
                maxIdx = idx;
            }
        }

        if (maxFreq > (n + 1) / 2) return "";

        char[] ans = new char[n];
        int writer = 0;
        while (map[maxIdx]-- > 0) {
            ans[writer] = (char) (maxIdx + 'a');
            writer += 2;
        }

        if (writer >= n) {
            writer = 1;
        }

        int start = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0) continue;

            if (writer >= n) {
                writer = start + 1;
                start += 1;
            }

            while (writer < n && map[i]-- > 0) {
                ans[writer] = (char) (i + 'a');
                writer += 2;
            }
        }

        return new String(ans);
    }
}
