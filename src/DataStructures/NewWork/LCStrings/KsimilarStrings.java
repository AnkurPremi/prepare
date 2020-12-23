package DataStructures.NewWork.LCStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class KsimilarStrings {
    public static void main(String[] args) {
        String A = "abcbca";
        String B = "ababcc";
        System.out.println(new KsimilarStrings().kSimilarity(A, B));
    }

    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;

        Map<Character, TreeSet<Integer>> map = new HashMap();
        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new TreeSet<Integer>());
            }
            map.get(c).add(i);
        }

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                TreeSet<Integer> set = map.get(a[i]);
                Integer idx = set.ceiling(i);
                while(b[idx] == a[idx]){
                    idx = set.ceiling(idx+1);
                }
                set.remove(idx);

                set = map.get(b[i]);
                set.remove(i);
                set.add(idx);
                char temp = b[i];
                b[i] = b[idx];
                b[idx] = temp;
                count++;
            } else{
                map.get(b[i]).remove(i);
            }
        }
        return count;
    }
}
