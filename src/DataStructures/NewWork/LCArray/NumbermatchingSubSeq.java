package DataStructures.NewWork.LCArray;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class NumbermatchingSubSeq {
    public static void main(String[] args) {
        String[] words = {"a", "bb", "acd", "ace"};
        String s = "abcde";
        new NumbermatchingSubSeq().numMatchingSubseq(s, words);
    }

    public int numMatchingSubseq(String S, String[] words) {
        List<StringCharacterIterator>[] waiting = new List[26];
        for (int c = 'a'; c <= 'z'; c++)
            waiting[c-'a'] = new ArrayList();
        for (String w : words)
            waiting[w.charAt(0)-'a'].add(new StringCharacterIterator(w));
        for (char c : S.toCharArray()) {
            List<StringCharacterIterator> advance = waiting[c-'a'];
            waiting[c-'a'] = new ArrayList();
            for (StringCharacterIterator it : advance)
                waiting[(it.next() % it.DONE) -'a'].add(it);
        }
        return waiting[0].size();
    }
}
