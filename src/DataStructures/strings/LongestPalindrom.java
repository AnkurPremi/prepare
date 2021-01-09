package DataStructures.strings;

public class LongestPalindrom {
    private static int lo, maxLen;

    public static void main(String[] args) {
        String a = "babadaaxaabcadxab";
        System.out.println(new LongestPalindrom().longestPalindrome(a));
    }

    private static String longestPalindrome(String s) {
        for(int i=0;i<s.length()-1;i++){
            extendPalindrome(s, i, i);//odd case
            extendPalindrome(s, i, i+1);//even case
        }
        return s.substring(lo, maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        //This is the condition when your palindrome is found and you are expanding it
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;//move left
            k++;//move right
        }
        //if my palindrome is now greater than curr maxLength .. update the maxLength
        //move the low pointer
        if(k-j-1 > maxLen){
            maxLen = k-j-1;
            lo = j+1;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public String longestPalindrome1(String s) {
        int curLen = 0;
        int start = -1;
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            if(isPalindrome(array, i - curLen - 1, i)) {
                start = i - curLen - 1;
                curLen += 2;
            } else if (isPalindrome(array, i - curLen, i)) {
                start = i - curLen;
                curLen += 1;
            }
        }
        return new String(array, start, curLen);
    }
    private boolean isPalindrome(char[] array, int start, int end) {
        if(start < 0) {
            return false;
        }
        while(start < end) {
            if(array[start++] != array[end--]) {
                return false;
            }
        }
        return true;
    }
}
