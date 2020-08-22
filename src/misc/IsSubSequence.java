package misc;

import java.util.*;

public class IsSubSequence {
    public static void main(String[] args) {
        String a = "abc";
        String b = "bbbpbbaasaaabrbbmbbqdatsdzasdmnopc";
//        System.out.println(isSubsequence(a, b));
        System.out.println(isSubsequenceWithMoreData(a, b));
    }

    private static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return false;
        else if (t == null || t.length() == 0) return false;
        else if (s.length() > t.length()) return false;

        int countS = 0;
        int countT = 0;
        while (countS < s.length() && countT < t.length()) {
            if (s.charAt(countS) == t.charAt(countT)) {
                countS++;
            }
            if (countS == s.length()) return true;
            countT++;
        }
        return false;
    }

    /**
     * there will lot of incoming s strings which we need to compare with t
     * since we are doing repetetive work
     * it's better to store string 't' in some kind easy accessible way
     * we will store characters of 't' in a map of char and list of indices of that char
     * e.g. t="abcbcbd" -> map<char, list<Integer>>  --> map.put('a', list.add('0'))
     * map.put('b', list.add('1,3,5'))
     * map.put('c', list.add('2,4'))
     * map.put('d', list.add('6'))
     * this is pre-processing
     * after this for every incoming string 's' - search first char of s in map
     * if not exist  - return false
     * if exist - search for the first index using binary search which is >= currIdx
     * -- if there is no idx found with such criteria - return false
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isSubsequenceWithMoreData(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.get(c) == null) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the string to search :");
            s = sc.next();
            int prevIdx = -1;
            int countS = 0;
            while (countS < s.length()) {
                char c = s.charAt(countS);
                if (map.get(c) == null) return false;
                prevIdx = binarySearch(prevIdx, map.get(c));
                if (prevIdx == -1) return false;
                countS++;
                if (countS == s.length()) return true;
            }
            return false;
        }
    }

    private static int binarySearch(int idx, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (list.get(mid) < idx) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start == list.size() ? -1 : list.get(start);
    }
}
