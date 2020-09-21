package DataStructures.strings;

//O(n + m)
public class KMPStringAlgo {
    public static void main(String[] args) {
        String text = "abcdxaaabaabaaabcbdyx";
        String pattern = "aabaabaaa";
        pattern = "aacaaea";
        checkIfPatternExist(text, pattern);
    }

    public static boolean checkIfPatternExist(String text, String pattern) {
        int[] lookupArr = buildSearchArray(pattern);
        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {
            if(text.charAt(i) == pattern.charAt(j)){
                i++; j++;
            }else{
                if(j == 0){
                    i++;
                } else{
                    j = lookupArr[j-1];
                }
            }
        }
        return j == pattern.length();
    }

    public static int[] buildSearchArray(String pattern) {
        int[] arr = new int[pattern.length()];
        int i = 0, j = 1;
        while (i >= 0 && j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                arr[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    j++;
                    continue;
                }
                i = arr[i - 1];
            }
        }
        return arr;
    }

}
