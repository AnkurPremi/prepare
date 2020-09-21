package DataStructures.strings;

public class CountAllBinarySubstrings {
    public static void main(String[] args) {
        String s = "00110011";
        new CountAllBinarySubstrings().countBinarySubstrings(s);
    }

    /**
     *
     preRun count the same item happend before (let say you have 0011, preRun = 2 when you hit the first 1, means there are two zeros before first '1')
     curRun count the current number of items (let say you have 0011, curRun = 2 when you hit the second 1, means there are two 1s so far)
     Whenever item change (from 0 to 1 or from 1 to 0), preRun change to curRun, reset curRun to 1 (store the curRun number into PreRun, reset curRun)
     Every time preRun >= curRun means there are more 0s before 1s, so could do count++ . (This was the tricky one, ex. 0011 when you hit the first '1', curRun = 1, preRun = 2, means 0s number is larger than 1s number, so we could form "01" at this time, count++ . When you hit the second '1', curRun = 2, preRun = 2, means 0s' number equals to 1s' number, so we could form "0011" at this time, that is why count++)

     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }
}
