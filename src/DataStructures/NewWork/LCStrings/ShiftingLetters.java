package DataStructures.NewWork.LCStrings;

public class ShiftingLetters {
    public static void main(String[] args) {
        String s = "ruu";
        int[] arr = {26, 9, 17};
        System.out.println(new ShiftingLetters().shiftingLetters(s, arr));
    }

    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();
        int shiftCount = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shiftCount += shifts[i];
            shiftCount %= 26;
            int v = ((arr[i] - 'a') + shiftCount) % 26;
            arr[i] = (char) (v+'a');
        }
        return new String(arr);
    }
}
