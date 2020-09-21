package DataStructures.strings;

public class Custom_Sort_String {
    public static void main(String[] args) {
        String s = "cba";
        String t = "abcd";
        String result = customSortString(s, t);
    }

    public static String customSortString(String S, String T) {
        int[] map = new int[26];
        for(char c : T.toCharArray()){
            map[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for(char c : S.toCharArray()){
            while(map[c - 'a'] > 0){
                builder.append(c);
                map[c - 'a']--;
            }
        }
        if(builder.length() == T.length()){
            return builder.toString();
        }else{
            for(int i=0; i< map.length ;i++){
                while(map[i] > 0){
                    builder.append((char)(i+'a'));
                    map[i]--;
                }
            }
        }
        System.out.println("Result: "+ builder.toString());
        return builder.toString();
    }
}
