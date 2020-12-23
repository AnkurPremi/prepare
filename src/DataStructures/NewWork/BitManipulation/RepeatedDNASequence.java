package DataStructures.NewWork.BitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {
    public static void main(String[] args) {
        System.out.println(new RepeatedDNASequence().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCCAAAAACCCCC"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;
        int prime = 3;
        int left = 0, right = 0, hash = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            hash += (s.charAt(i) - '@') * Math.pow(prime, i);
            right++;
        }
        while (right < s.length()) {
            hash += (s.charAt(right) - '@') * Math.pow(prime, 9);

            if (right - left + 1 == 10) {
                if (map.containsKey(hash) && map.get(hash) == 1) {
                    result.add(s.substring(left, right + 1));
                    map.put(hash, 2);
                } else {
                    map.put(hash, map.getOrDefault(hash, 0) + 1);
                }
            }

            hash -= (s.charAt(left++) - '@');
            hash /= prime;
            right++;
        }
        return result;
    }

}
