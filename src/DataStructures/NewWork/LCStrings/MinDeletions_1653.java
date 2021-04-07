package DataStructures.NewWork.LCStrings;

public class MinDeletions_1653 {
    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(new MinDeletions_1653().minimumDeletions(s));
    }

    public int minimumDeletions(String s) {
        int n = s.length();
        int v1 = 0 , v2 = 0;

        int bCount = 0;
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);

            if(c == 'a'){
                v2 = Math.min(bCount, 1 + v1);
                v1 = v2;
            } else {
                v2 = v1;
                bCount++;
            }
        }

        return v2;
    }
}
