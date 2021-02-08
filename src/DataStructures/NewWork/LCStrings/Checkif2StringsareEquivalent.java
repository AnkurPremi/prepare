package DataStructures.NewWork.LCStrings;

public class Checkif2StringsareEquivalent {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};

        System.out.println(new Checkif2StringsareEquivalent().arrayStringsAreEqual(word1, word2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int x = 0, y = 0;
        int p = 0, q = 0;
        while(i < word1.length && j < word2.length){
            if(p >= word1[i].length()){
                if(i + 1 == word1.length) break;
                p = 0;
                i++;
                continue;
            }

            if(q >= word2[j].length()){
                if(j + 1 == word2.length) break;
                q = 0;
                j++;
                continue;
            }

            if(word1[i].charAt(p) != word2[j].charAt(q)) return false;
            p++;
            q++;
            x++;
            y++;
        }

        return x == y && p == word1[word1.length - 1].length() && q == word2[word2.length - 1].length();
    }
}
