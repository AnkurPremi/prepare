package DataStructures.NewWork.LCStrings;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "2206";
        System.out.println(new DecodeWays().numDecodings(s));
    }

    public int numDecodings(String s) {
        int[] count = {0};
        helper(s, 0, count);
        return count[0];
    }

    public void helper(String s, int idx, int[] count){
        if(idx == s.length()){
            count[0]++;
            return;
        }

        if(s.charAt(idx) == '0') return;

        helper(s, idx+1, count);

        if(idx + 1 < s.length()){
            int num = (s.charAt(idx) -'0') * 10 + (s.charAt(idx+1)-'0');
            if(num < 27 && num > 0)
                helper(s, idx+2, count);
        }

    }
}
