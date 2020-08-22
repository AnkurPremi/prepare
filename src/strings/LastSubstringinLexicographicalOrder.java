package strings;

//https://leetcode.com/problems/last-substring-in-lexicographical-order/
public class LastSubstringinLexicographicalOrder {
    public static void main(String[] args) {
        String s = "leetcodte";
        System.out.println(new LastSubstringinLexicographicalOrder().lastSubstring(s));
    }

    //we will store the chars in int array
    //starting from end we will check which is the last char.
    //then we will compare substrings using that char as starting
    public String lastSubstring(String s) {

        int max = -1;
        int i = 0;
        String maxStr = "";
//        List<Integer> maxCharIdxList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            int charPos = c - 'a';
            if (charPos >= max) {
                if (charPos > max) {
                    max = charPos;
//                    maxCharIdxList.clear();
                }
//                maxCharIdxList.add(i);
                String p = s.substring(i);
                int k = maxStr.compareTo(p);
                if(k < 0) maxStr = p;
            }
            i++;
        }
        return maxStr;
    }
}
