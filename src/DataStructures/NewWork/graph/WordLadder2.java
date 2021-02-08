package DataStructures.NewWork.graph;

import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new WordLadder2().findLadders(start, end, list));
    }

    List<List<String>> result = new ArrayList();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return result;
        }
        Map<String, List<String>> map = getChildren(beginWord, endWord, dict);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(beginWord, endWord, path, map);
        return result;
    }

    private void findLadders(String start, String end, List<String> list, Map<String, List<String>> map) {
        if (start.equals(end)) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(start)) return;

        for (String str : map.get(start)) {
            list.add(str);
            findLadders(str, end, list, map);
            list.remove(list.size() - 1);
        }
    }

    private Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> wordSet) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        boolean isOpposite = false;
        boolean isFound = false;

        while (!start.isEmpty() && !isFound) {
            if (start.size() > end.size()) {
                isOpposite = !isOpposite; //turn the traversal
                Set<String> temp = start;
                start = end;
                end = temp;
            }

            Set<String> set = new HashSet<>(); //adding neighbours of start node
            for (String curr : start) {
                visited.add(curr);
                for (String next : getNext(curr, wordSet)) {
                    if (visited.contains(next) || start.contains(next)) {
                        continue;
                    }
                    if (end.contains(next)) {
                        isFound = true;
                    }
                    set.add(next);
                    String parent = isOpposite ? next : curr;
                    String child = isOpposite ? curr : next;
                    if (!map.containsKey(parent)) {
                        map.put(parent, new ArrayList());
                    }
                    map.get(parent).add(child);
                }
            }
            start = set;
        }
        return map;
    }

    private List<String> getNext(String curr, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        char[] arr = curr.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char t = arr[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (t == j) continue;
                arr[i] = j;
                String next = new String(arr);
                if (wordSet.contains(next)) {
                    list.add(next);
                }
            }
            arr[i] = t;
        }
        return list;
    }


//    public void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> path) {
//        if (beginWord.equals(endWord)) {
//            res.add(new ArrayList<>(path));
//        }
//        if (!map.containsKey(beginWord)) {
//            return;
//        }
//        for (String next : map.get(beginWord)) {
//            path.add(next);
//            findLadders(next, endWord, map, res, path);
//            path.remove(path.size() - 1);
//        }
//    }
//
//    public Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> dict) {
//        Map<String, List<String>> map = new HashMap<>();
//        Set<String> start = new HashSet<>();
//        start.add(beginWord);
//        Set<String> end = new HashSet<>();
//        Set<String> visited = new HashSet<>();
//        end.add(endWord);
//        boolean found = false;
//        boolean isBackward = false;
//        while (!start.isEmpty() && !found) {
//            if (start.size() > end.size()) {
//                Set<String> tem = start;
//                start = end;
//                end = tem;
//                isBackward = !isBackward;
//            }
//            Set<String> set = new HashSet<>();
//            for (String cur : start) {
//                visited.add(cur);
//                for (String next : getNext(cur, dict)) {
//                    if (visited.contains(next) || start.contains(next)) {
//                        continue;
//                    }
//                    if (end.contains(next)) {
//                        found = true;
//                    }
//                    set.add(next);
//                    String parent = isBackward ? next : cur;
//                    String child = isBackward ? cur : next;
//                    if (!map.containsKey(parent)) {
//                        map.put(parent, new ArrayList<>());
//                    }
//                    map.get(parent).add(child);
//
//                }
//            }
//            start = set;
//        }
//        return map;
//
//    }
//    private List<String> getNext(String cur, Set<String> dict) {
//        List<String> res = new ArrayList<>();
//        char[] chars = cur.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            char old = chars[i];
//            for (char c = 'a'; c <= 'z'; c++) {
//                if (c == old) {
//                    continue;
//                }
//                chars[i] = c;
//                String next = new String(chars);
//                if (dict.contains(next)) {
//                    res.add(next);
//                }
//            }
//            chars[i] = old;
//        }
//        return res;
//    }

    //---> Gives TLE
//    List<List<String>> result = new ArrayList();
//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Set<String> wordSet = new HashSet<>(wordList);
//        List<String> list = new ArrayList<>();
//        list.add(beginWord);
//        dfs(wordSet, beginWord, endWord, list);
//        return result;
//    }
//
//    private void dfs(Set<String> wordSet, String start, String end, List<String> list) {
//        if (start.equals(end)) {
//            if (!result.isEmpty() && result.get(0).size() > list.size()) {
//                result = new ArrayList();
//            }
//            result.add(new ArrayList(list));
//            return;
//        }
//
//        if (!result.isEmpty() && list.size() >= result.get(0).size()) return;
//
//        char[] arr = start.toCharArray();
//        for (int i = 0; i < start.length(); i++) {
//            char t = arr[i];
//            for (char j = 'a'; j <= 'z'; j++) {
//                if (j == t) continue;
//                arr[i] = j;
//                String s = new String(arr);
//                if (wordSet.contains(s)) {
//                    wordSet.remove(s);
//                    list.add(s);
//                    dfs(wordSet, s, end, list);
//                    list.remove(list.size() - 1);
//                    wordSet.add(s);
//                }
//            }
//            arr[i] = t;
//        }
//    }
}
