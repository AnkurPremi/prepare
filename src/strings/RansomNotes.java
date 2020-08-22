package strings;

public class RansomNotes {
    public static void main(String[] args) {
        String ransomNote = "acbd";
        String availableDict = "cabaa";
        System.out.println(canConstruct(ransomNote, availableDict));
    }

    public static boolean canConstruct(String ransomNote, String availableDict) {
        if (ransomNote == null || ransomNote.isEmpty()) return true;
        else if (availableDict == null || availableDict.isEmpty()) return false;
        else {
            int[] dict = new int[26];
            for (int i = 0; i < availableDict.length(); i++) {
                dict[availableDict.charAt(i) - 'a']++;
            }
            for (int p = 0; p < ransomNote.length(); p++) {
                if (dict[ransomNote.charAt(p) - 'a'] > 0) {
                    dict[ransomNote.charAt(p) - 'a']--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
