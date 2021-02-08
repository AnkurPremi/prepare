package DataStructures.NewWork.graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(new WordLadder().ladderLength(start, end, list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet(wordList);

        Queue<String> q = new LinkedList();
        q.offer(beginWord);
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                char[] arr = q.poll().toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char tmp = arr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        arr[j] = k;
                        String s = new String(arr);
                        if (set.contains(s)) {
                            if (endWord.equals(s)) return count + 1;
                            q.offer(s);
                        }
                    }
                    arr[j] = tmp;
                }

            }
            count++;
        }
        return 0;
    }
}
