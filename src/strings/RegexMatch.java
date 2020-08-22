package strings;

public class RegexMatch {
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mi.*is*p*.";
        boolean a= isMatch(s, p);
        System.out.println(a);
    }

    public static boolean isMatch(String s, String p) {
        if(s==null || s.isEmpty() || p == null || p.isEmpty()) return false;
        char[] arrStr = s.toCharArray();
        char[] arrPattern = p.toCharArray();
        int i = 0, j = 0;
        while (i < arrStr.length && j < arrPattern.length){
            if(arrStr[i] == arrPattern[j]){
                i++;j++;
                continue;
            }
            if(arrPattern[j] == '.'){
                i++;j++;
                continue;
            }
            if(arrPattern[j] == '*'){
                if(j-1 >= 0 && (arrPattern[j-1] == arrStr[i] || arrPattern[j-1] == '.')){
                    i++;j++;
                    continue;
                }
            }
            if(arrPattern[j] != arrStr[i]){
                if(j+1 < arrPattern.length && arrPattern[j+1] == '*'){
                    i++;j++;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
