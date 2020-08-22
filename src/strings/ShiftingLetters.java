package strings;

import java.util.HashMap;
import java.util.Map;

public class ShiftingLetters {
    public static void main(String[] args) {
        String S = "gdhbjaph";
        int[] shifts = {74, 34, 65, 30, 43, 91, 14, 10};
        System.out.println(new ShiftingLetters().shiftingLetters2(S, shifts));
    }

    public String shiftingLetters(String S, int[] shifts) {
        if (shifts.length == 0) return S;
        else {
            Map<String, String> map = new HashMap<>();
            StringBuilder builder = new StringBuilder(S);
            for (int i = 0; i < shifts.length; i++) {
                int shift = shifts[i];
                while (shift > 26) {
                    shift = shift % 26;
                }
                String str = builder.toString();
                builder.setLength(0);
                if (map.containsKey(str + "-" + shift)) {
                    builder.append(map.get(str + "-" + shift));
                    continue;
                }
                int j = 0;
                for (; j <= i; j++) {
                    char p = (char) ((str.charAt(j) - 'a' + shift) % 26 + 'a');
                    builder.append(p);
                }
                if (j < S.length()) {
                    builder.append(S.substring(j));
                }
                map.put((str + "-" + shift), builder.toString());
            }
            return builder.toString();
        }
    }


    public String shiftingLetters1(String S, int[] shifts) {
        char[] arr = S.toCharArray();
        int shift = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            arr[i] = (char) ((arr[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(arr);
    }

    public String shiftingLetters2(String S, int[] shifts) {
        char[] arr = S.toCharArray();
        int shift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shifts[i] = (shift + shifts[i])%26;
            shift = shifts[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ((arr[i] - 'a' + shifts[i])% 26 + 'a');
        }
        return String.valueOf(arr);
    }
}
