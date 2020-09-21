package DataStructures.strings;

public class Shortest_Palindrome {
    public static void main(String[] args) {
        String s = "aacecaaa";
        s = "abcd";
        new Shortest_Palindrome().shortestPalindrome1(s);
    }

    //First try to find the biggest palindrome
    public static String shortestPalindrome(String str) {
        int center = getBiggestPalindromeCenter(str);
        if(center == -1) return str;
        int start = center-1, end = center+1;
        while(true){
           if(start < 0 && end < str.length()){
               str = str.charAt(end) + str;
               start = 0;
               end += 1;
           }else if(end >= str.length() && start > 0){
               str = str + str.charAt(start);
               end = str.length()-1;
               start = start - 1;
           }else if(start >=0)
            return "1";
        }

    }

    public static int getBiggestPalindromeCenter(String str){
        int maxLength = 1, start = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;

                // Palindrome
                if (flag == 1 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        if(maxLength == str.length()) return -1;
        return maxLength/2;
    }


    public String shortestPalindrome1(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);

        //get the maximum palin part in s starts from 0
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public int[] getTable(String s){
        //get lookup table
        int[] table = new int[s.length()];

        //pointer that points to matched char in prefix part

        int index = 0;
        //skip index 0, we will not match a string with itself
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
                //we can extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index ++;
            }else{
                //match failed, we try to match a shorter substring

                //by assigning index to table[i-1], we will shorten the match string length, and jump to the
                //prefix part that we used to match postfix ended at i - 1
                index = table[i-1];

                while(index > 0 && s.charAt(index) != s.charAt(i)){
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index-1];
                }

                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if(s.charAt(index) == s.charAt(i)){
                    //if match, then extend one char
                    index ++ ;
                }

                table[i] = index;
            }

        }

        return table;
    }
}
