package DataStructures.NewWork.LCStrings;

import java.util.Arrays;

public class LongestSubStringWithRepeatingChars {
    public static void main(String[] args) {
        String b = "  &&&&&&7$@(*(@*((&(%&($@(%&(&(@&********************$$$$$$$$$%%@#@)($@)$*@)$*@)*)@%*@()%$*(%&@(%&%&(@%$&(%&@(%%(*@%*@*%)@%)@%*)@%*jfifsifhsfihsifhw9523932j2932398jf389fj834ru40k2303934u9jf0xasca64fsa6f4s6df4s6f4sd6f4sf4sfs4dfsdf4sd8f7s8e7f8sefs8ef7sefwse/fef/wf/we/fwe/fw/f ";
        System.out.println(new LongestSubStringWithRepeatingChars().lengthOfLongestSubstring(b));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int max = 0;
        int start = 0;
        int i = 0;
        Arrays.fill(last, -1);
        while (i < s.length()) {
            if (last[s.charAt(i)] != -1) {
                start = Math.max(start, last[s.charAt(i)] + 1);
            }
            last[s.charAt(i)] = i;
            max = Math.max(max, i - start + 1);
            i++;
        }


        return max;
    }
}
