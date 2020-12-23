package DataStructures.NewWork.DP;

public class TwoKeysKeyboardMinSteps {
    public static void main(String[] args) {
        System.out.println(new TwoKeysKeyboardMinSteps().minSteps(15));
    }

    public int minSteps(int n) {
        int ans = 0, d = 2;
        while(n > 1){
            if(n == 2 || n == 3)
                return n + ans;
            if(n % 2 == 0){
                n = n/2;
                ans += 2;
            } else {
                if(n % d == 0){
                    ans += n/d;
                    n = d;
                }else {
                    d++;
                }
            }
        }
        return ans;
    }
}
