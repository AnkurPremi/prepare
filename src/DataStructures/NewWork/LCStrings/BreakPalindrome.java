package DataStructures.NewWork.LCStrings;

public class BreakPalindrome {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new BreakPalindrome().breakPalindrome(s));
    }

    public String breakPalindrome(String p) {
        if(p.length() == 1) return "";
        char[] arr = p.toCharArray();
        boolean found = false;
        int aCount = 0;
        for(int i=0 ; i<p.length()/2 ; i++){
            int val = arr[i] - 'a';
            if(val == 0){
                aCount++;
            } else{
                arr[i] = 'a';
                found = true;
                break;
            }
        }
        if(found) return new String(arr);
        if(aCount == p.length()/2) {
            arr[arr.length-1] = 'b';
            return new String(arr);
        }

        return "";
    }
}
