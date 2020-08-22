package strings;

public class Buddy_Strings {
    public static void main(String[] args) {
        String a = "ab";
        String b = "ab";
        System.out.println(buddyStrings(a, b));
    }

    public static boolean buddyStrings(String A, String B) {
        if (A == null || A.isEmpty() || B == null || B.isEmpty() || A.length() != B.length()) return false;
        else {
            char replacedString = ' ';
            char[] arrA = A.toCharArray();
            char[] arrB = B.toCharArray();
            for (int i = 0; i < arrA.length; i++) {
                if (arrA[i] != arrB[i]) {
                    if (replacedString == ' ') {
                        replacedString = arrA[i];
                        arrA[i] = arrB[i];
                    } else {
                        char c = arrA[i];
                        arrA[i] = replacedString;
                        if (String.valueOf(arrA).equals(String.valueOf(arrB))) {
                            return true;
                        }
                        arrA[i] = c;
                    }
                }
            }
        }
        return false;
    }
}
