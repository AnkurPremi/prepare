package DataStructures.NewWork.LCStrings;

public class CountSubStringwith1 {
    public static void main(String[] args) {
        String s = "111";
        System.out.println(new CountSubStringwith1().numSub(s));
    }

    public int numSub(String s) {
        int ans = 0;
        int count = 0;
        int mod = (int) 1e7;
        for(char c : s.toCharArray()){
            if(c == '0'){
                count %= mod;
                count = (count * (count-1)) % mod;
                count = (count >> 1) + count;
                ans += count;
                ans %= mod;
                count = 0;
            }
            count++;
        }
        count = ((count * (count-1)) >> 1) + count;
        ans += count;
        ans %= mod;
        return ans;
    }
}
