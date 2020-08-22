package strings;

//https://leetcode.com/problems/reorganize-string/submissions/
public class Reorganize_String13 {
    public static void main(String[] args) {
        String s = "abccdd";
        String result = reorganizeString(s);
    }

    public static String reorganizeString(String S) {
        int[] map = new int[26];
        for(char c : S.toCharArray()){
            map[c -'a']++;
        }
        int max = 0; char letter = ' ';
        for(int i=0;i<map.length ;i++){
            int val = map[i];
            if(val > max){
                max = val;
                letter = (char)('a' + i);
            }
        }
        //if there exist a character which has duplicate values more than the half of String length
        //then it is not possible to produce reorganized string
        if(max > (S.length()+1)/2) return "";

        char[] result = new char[S.length()];
        int i=0;
        //adding the character with max frequency at even spots in the result array
        while(map[letter-'a'] > 0){
            result[i] = letter;
            i+=2;
            map[letter - 'a']--;
        }

        //add all the remaining characters starting with
        for(int j=0; j<map.length; j++){
            if(map[j] > 0){
                if(i >= result.length){
                    i=1;
                }
                result[i] = (char)('a' + j);
                i+=2;
                map[j]--;
                //if the char is duplicate than don't move forward.. keep on adding the element
                if(map[j] > 0){
                    j--;
                }
            }
        }
        return String.valueOf(result);
    }
}
