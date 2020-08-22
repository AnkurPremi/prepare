package strings;

//https://leetcode.com/problems/long-pressed-name/
public class LongPressedName {
    public static void main(String[] args) {
        String name = "kikcxmvzi";
        String typed = "kiikcxxmmvvzz";
        System.out.println(new LongPressedName().isLongPressedName2(name, typed));

    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) return true;
        if (name.length() > typed.length()) return false;
        int[] nameMap = getWordMap(name);
        int[] typedMap = getWordMap(typed);
        for (int i = 0; i < nameMap.length; i++) {
            if ((typedMap[i] == 0 && nameMap[i] != 0) || (typedMap[i] < nameMap[i]) || (typedMap[i] != 0 && nameMap[i] == 0)) {
                return false;
            } else {
                typedMap[i] = 0;
            }
        }
        return true;
    }

    public boolean isLongPressedName1(String name, String typed) {
        if (name.equals(typed)) return true;
        if (name.length() > typed.length()) return false;
        int i = 0, j = 0;
        boolean iMoved = false;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) {
                if (iMoved) {
                    if (name.charAt(i) == typed.charAt(j - 1)) {
                        i++;
                        continue;
                    }
                    return false;
                } else {
                    iMoved = true;
                    i++;
                }
            } else {
                iMoved = false;
                j++;
            }
        }
        return i == name.length() && j == typed.length();
    }

    public boolean isLongPressedName2(String name, String typed) {
        if (name.equals(typed)) return true;
        if (name.length() > typed.length()) return false;
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i == 0 || name.charAt(i - 1) != typed.charAt(j)) {
                return false;
            } else {
                j++;
            }
        }
        if (j < typed.length()) {
            if (typed.charAt(j) != name.charAt(i)) {
                return false;
            }
            j++;
        }
        return i == name.length() && j == typed.length() && name.charAt(i - 1) == typed.charAt(j - 1);
    }

    public static int[] getWordMap(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}
