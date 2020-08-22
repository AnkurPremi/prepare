package codechef;

public class Lapindrome {
    public static void main(String[] args) {
        String s = "abccab";
        String k = "rotor";
        String p = "aa";
        System.out.println(isLapindrome(p));
        System.out.println(isLapindrome(k));
        System.out.println(isLapindrome(s));
    }

    public static boolean isLapindrome(String s){
        if(s == null || s.isEmpty() || s.length() == 1)return true;
        else{
            int left = s.length()/2 - 1;
            int right = s.length()%2 != 0 ? left + 2 : left + 1;

            int[] leftChars = new int[26];
            int[] rightChars = new int[26];

            for(char c : s.substring(0, left+1).toCharArray()){
                leftChars[c - 'a']++;
            }
            for(char c : s.substring(right).toCharArray()){
                rightChars[c - 'a']++;
            }
            for(int i=0; i<26;i++){
                if(leftChars[i] != rightChars[i]){
                    return false;
                }
            }
        }
        return true;
    }
}
