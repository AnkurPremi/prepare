package DataStructures.NewWork.LCStrings;

public class OneKeyKeyboard {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba";
        System.out.println(new OneKeyKeyboard().calculateTime(keyboard, word));
    }

    public int calculateTime(String keyboard, String word) {
        int[] location = new int[26];
        for(int i = 0 ; i < keyboard.length() ; i++){
            location[keyboard.charAt(i) - 'a'] = i;
        }

        int ans = 0;
        int ptr = 0;
        for(int i = 0 ; i < word.length() ; i++){
            ans += Math.abs(location[word.charAt(i) - 'a'] - ptr);
            ptr = location[word.charAt(i) - 'a'];
        }

        return ans;
    }
}
