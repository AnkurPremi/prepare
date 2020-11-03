package DataStructures.NewWork.LCStrings;

public class StringCanBreak {
    public static void main(String[] args) {
        String s1 = "abe";
        String s2 = "acd";
        System.out.println(new StringCanBreak().checkIfCanBreak(s1, s2));
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (char c : s1.toCharArray()) {
            s1Map[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            s2Map[c - 'a']++;
        }
        int[] map1 = s1Map.clone();
        int[] map2 = s2Map.clone();
        return isPossible(s1Map, s2Map) || isPossible(map2, map1);
    }

    public boolean isPossible(int[] s1Map, int[] s2Map) {
        int i = 25, j = 25;
        while (i >= 0) {
            while (i >=0 && s1Map[i] == 0) {
                i--;
            }

            while (j >= 0 && s2Map[j] == 0) {
                j--;
            }

            while (j >= 0 && s1Map[i] > 0 && s2Map[j] != 0) {
                if (i > j) return false;
                if (s2Map[j] == 0)
                    j--;
                else {
                    s2Map[j]--;
                    s1Map[i]--;
                    if(s1Map[i] == 0) break;
                }
            }
        }
        return true;
    }
}
