package strings;

//https://www.youtube.com/watch?v=NH3UYyQQ2b4
//leetcode-358
public class PlaceCharsKdistanceApart {
    public static void main(String[] args) {
        String s ="aabbcc";
        int k = 3;
        String result = reorganizeString(s, k);
        System.out.println(result);
    }

    public static String reorganizeString(String s, int k) {
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }
        int max = 0;
        char letter = ' ';
        for(int i=0; i< map.length ;i++){
            int val = map[i];
            if(val > max){
                max = val;
                letter = (char)(i + 'a');
            }
        }

        if(k*max >= s.length()+1) return "";
        int i=0;
        char[] result = new char[s.length()];
        while(map[letter - 'a'] > 0){
            result[i] = letter;
            map[letter - 'a']--;
            i+=k;
        }

        for (int j = 0; j < map.length; j++) {
            if(map[j] > 0){
                if(i >= result.length){
                    i=k;
                }
                result[i] = (char)(j + 'a');
                i+=k;
                if(map[j]>0){
                    j--;
                }
            }
        }
        System.out.println("Result: "+ String.valueOf(result));
        return String.valueOf(result);
    }
}
