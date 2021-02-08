package DataStructures.NewWork.Misc;

import java.util.*;

class AutocompleteSystem {

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, times);
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
    }

    private Map<String, Integer> map;
    private TrieNode root;

    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap();
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            addWord(sentences[i], root);
            map.put(sentences[i], times[i]);
        }

    }

    TrieNode node = null;
    StringBuilder builder = new StringBuilder();
    boolean notFound = false;

    public List<String> input(char c) {
        if (node == null) node = root;

        if (c == '#') {
            return doHashLogic();
        }

        builder.append(c);

        //if earlier the word was not found ..no need to proceed now.
        //just add the char to Stringbuilder for later use
        if (notFound) return new ArrayList();

        List<String> words = searchWords(c);

        if (words.isEmpty()) {
            node = null;
            notFound = true;
            return words;
        } else {
            return sortWithHotness(words);
        }
    }

    //Add the word to the TrieNode if already exist
    //if already present then..just increase the hotness value
    private List<String> doHashLogic() {
        String s = builder.toString();
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            addWord(s, root);
            map.put(s, 1);
        }
        builder.setLength(0);
        node = null;
        notFound = false;
        return new ArrayList();
    }

    //Return the list sorted with hotness and in alphabetical order
    private List<String> sortWithHotness(List<String> words) {

        //if list size is less than equal to 3
        if (words.size() <= 3) {
            Collections.sort(words, (a, b) -> {
                int v1 = map.get(a);
                int v2 = map.get(b);
                return v1 == v2 ? a.compareTo(b) : v2 - v1;
            });
            return words;
        }


        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int v1 = map.get(a);
            int v2 = map.get(b);
            return v1 == v2 ? a.compareTo(b) : v2 - v1;
        });

        int k = 3;
        for (String s : words) {
            pq.offer(s);
        }

        List<String> ans = new ArrayList();
        while (k > 0) {
            k--;
            ans.add(pq.poll());
        }
        return ans;
    }

    //search list of words with char c
    //TrieNode node is an instance variable
    //so that next search will start from where we left earlier
    private List<String> searchWords(char c) {
        int asciiVal = 0;
        if (c == ' ') {
            asciiVal = 26;
        } else {
            asciiVal = c - 'a';
        }
        if (node.next[asciiVal] == null) return new ArrayList();
        node = node.next[asciiVal];
        return node.list;
    }

    //add the word to the Trie
    private void addWord(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int asciiVal = 0;
            if (c == ' ') {
                asciiVal = 26;
            } else {
                asciiVal = c - 'a';
            }

            if (node.next[asciiVal] == null) {
                node.next[asciiVal] = new TrieNode();
            }
            node = node.next[asciiVal];
            node.list.add(word);
        }
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[27];
        List<String> list;

        TrieNode() {
            list = new ArrayList();
        }
    }
}


