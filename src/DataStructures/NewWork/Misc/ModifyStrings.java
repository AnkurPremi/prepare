package DataStructures.NewWork.Misc;

import java.math.BigDecimal;

public class ModifyStrings {
    public static void main(String[] args) {

        System.out.println(new ModifyStrings().modifyString("?aqse"));
    }

    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int[] map = new int[26];

        int present = 0;
        for(int i=0 ; i<n ; i++){
            if(arr[i] != '?')
                map[arr[i] - 'a']++;
            else
                present = 1;
        }

        if(present == 0) return s;

        for(int i=0 ; i<n ; i++){
            if(arr[i] == '?'){
                if(i == 0){
                    if(i+1 < n){
                        arr[i] = (char)(arr[i+1] + 1);
                    }
                }
            }
        }
return s;
    }
}
