package DataStructures.NewWork.LCStrings;

public class WaysToSplitString {
    public static void main(String[] args) {
        String s = "101010";
        System.out.println(new WaysToSplitString().numWays(s));
    }

    public int numWays(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            count += s.charAt(i) - '0';
        }

        if(count % 3 != 0) return 0;
        int minReq = count / 3;

        int cutFromFront = 0;
        int j = 0;
        while(j < s.length() && cutFromFront != minReq){
            cutFromFront += s.charAt(j) - '0';
            j++;
        }

        int left = j - 1;
        int right = j;
        long ans = 0;

        while(j < s.length() && s.charAt(j) != '1'){
            right++;
            j++;
        }

        int v1 = right - left;

        int cutFromBack = 0;
        j = s.length() - 1;
        while(j >= 0 && cutFromBack != minReq){
            cutFromBack += s.charAt(j) - '0';
            j--;
        }

        left = j + 1;
        right = j;

        while(j >= 0 && s.charAt(j) != '1'){
            right--;
            j--;
        }

        int v2 = left - right;

        ans = v1 * v2;
        int mod = (int) 1e9 + 7;

        return (int)(ans % mod);
    }
}
