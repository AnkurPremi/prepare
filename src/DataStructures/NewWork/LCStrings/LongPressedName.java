package DataStructures.NewWork.LCStrings;

public class LongPressedName {
    public static void main(String[] args) {
        String s = "pyplrz";
        String t = "ppyypllr";
        System.out.println(new LongPressedName().isLongPressedName(s, t));
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int n = name.length(), m = typed.length();
        if(m < n) return false;
        while(i < n){
            char c = name.charAt(i);
            if(c != typed.charAt(j)){
                if(i>0 && name.charAt(i-1) == typed.charAt(j)){
                    j++;
                } else{
                    return false;
                }
            } else{
                i++;
                j++;
            }

            if(j > m-1 && i == n-1)
                return false;
        }
        while(j < m){
            if(name.charAt(n-1) != typed.charAt(j++))
                return false;
        }

        return true;
    }
}

//            if(c != typed.charAt(j)) {
//                if(j > 0 && typed.charAt(j-1) == c){
//                    while(j < m && typed.charAt(j-1) == c)
//                        i++;
//                }
//            }
//            else {
//                while (j < m && c == typed.charAt(j))
//                    j++;
//            }
//            if(j == m-1 && n < n-1)
//                return false;
//            i++;