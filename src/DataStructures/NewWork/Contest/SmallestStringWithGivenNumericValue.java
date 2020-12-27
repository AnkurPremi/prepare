package DataStructures.NewWork.Contest;

//https://leetcode.com/problems/smallest-string-with-a-given-numeric-value
public class SmallestStringWithGivenNumericValue {
    public static void main(String[] args) {
        int n = 3, k = 27;
        System.out.println(new SmallestStringWithGivenNumericValue().getSmallestString(n, k));
    }

    public String getSmallestString(int n, int k) {
        helper(n, k, new StringBuilder());
        return null;
    }

    private String helper(int n, int k, StringBuilder builder){
        if(n == 0 && k == 0) return builder.reverse().toString();
        if(n <= 0 || k <= 0) return null;
        if(n == k){
            while(n > 0){
                builder.append('a');
                n--;
            }
            return builder.reverse().toString();
        }
        String s = null;
        for(int i=k ; i>=0 ; i--){
//            if(k - i - 1 < 0) continue;
            char c = (char)(i + 'a');
            int len = builder.length();
            String p = helper(n-1, k - i - 1, builder.append(c));
            if(p != null) {
                if (s == null) s = p;
                else {
                    if (s.compareTo(p) > 0) {
                        s = p;
                    }
                }
            }
            builder.setLength(len);
        }
        return s;
    }
}
