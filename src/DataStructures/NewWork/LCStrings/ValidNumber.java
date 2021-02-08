package DataStructures.NewWork.LCStrings;

public class ValidNumber {
    public static void main(String[] args) {
        String s = "-1.";
        System.out.println(new ValidNumber().isNumber(s));
    }

    public boolean isNumber(String s) {
        int signCnt = 0, dotCnt = 0, eCnt = 0, ECnt = 0;
        int intAfterE = 0, intCnt = 0;

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                if (eCnt == 1 || ECnt == 1) intAfterE += 1;
                else intCnt += 1;
            } else if (c == '.') {
                dotCnt += 1;
                if (dotCnt > 1) return false;
            } else if (c == '+' || c == '-') {
                if (i == 0 || (i - 1 > 0 && s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                    signCnt += 1;
                    if (signCnt > 2) return false;
                } else {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (c == 'e')
                    eCnt += 1;
                else
                    ECnt += 1;

                if (eCnt > 1 || i == s.length() || dotCnt == 1) return false;

            } else {
                return false;
            }
            i++;
        }

        if ((eCnt == 1 || ECnt == 1) && (intAfterE == 0 || intCnt == 0)) return false;

        if (dotCnt == 1 && intCnt == 0) return false;

        return true;
    }
}
