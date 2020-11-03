package DataStructures.NewWork.LCStrings;

public class LOngestSubStrWithKDistinctChars {
    public static void main(String[] args) {
        String s = "cca3492u9u2302m34248304982498304m248m294824820240m045678673675657nnq4q545qwjdqoiu((((*$$$*)$*$*$$*$)$*)$*$$*$*()@*$$*@(*$@)JJabbb";
        System.out.println(new LOngestSubStrWithKDistinctChars().lengthOfLongestSubstringTwoDistinct(s));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        return helper(s, 2);
    }

    private int helper(String s, int K) {
        int[] map = new int[256];
        int count = 0;
        int l = 0, r = 0;
        int max = 0;
        while (r < s.length()) {
            if (map[s.charAt(r)] == 0) {
                count++;
            }
            map[s.charAt(r)]++;

            if (count > K) {
                max = Math.max(max, r - l);
                while (l < s.length() && count > K) {
                    map[s.charAt(l)]--;
                    if (map[s.charAt(l)] == 0)
                        count--;
                    l++;
                }
            }
            r++;
        }
        return Math.max(max, r - l);
    }
}
