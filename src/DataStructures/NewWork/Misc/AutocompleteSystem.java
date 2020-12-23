package DataStructures.NewWork.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class AutocompleteSystem {
    public static void main(String[] args) {
        String[] words = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5,3,2,2};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(words, times);
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('#'));
    }

    List<String> sentenceList;
    TrieNode root;
    StringBuilder builder;
    TrieNode tempNode;

    public AutocompleteSystem(String[] sentences, int[] times) {
        builder = new StringBuilder();
        root = new TrieNode();
        tempNode = root;
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i], times[i], i);
        }
        sentenceList = new ArrayList(Arrays.asList(sentences));
    }

    private void addToTrie(String sentence, int times, int i) {
        TrieNode node = root;
        for (int j = 0; j < sentence.length(); j++) {
            int k = sentence.charAt(j) - ' ';
            if (node.next[k] == null) {
                node.next[k] = new TrieNode();
            }
            node.next[k].list.add(new Pair(i, times));
            node = node.next[k];
        }
    }


    public List<String> input(char c) {
        List<String> result = new ArrayList();
        if (c == '#') {
            tempNode = root;
            String sent = builder.toString();
            addToTrie(sent, 1, sentenceList.size());
            sentenceList.add(sent);
            builder.setLength(0);
            return result;
        }
        tempNode = tempNode.next[c - ' '];
        if (tempNode == null) {
            return result;
        }
        builder.append(c);


        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            return p1.times == p2.times ?
                    sentenceList.get(p1.idx).compareTo(sentenceList.get(p2.idx)) : p2.times - p1.times;
        });

        List<Pair> list = tempNode.list;
        for (int i = 0; i < list.size(); i++) {
            pq.offer(list.get(i));
        }

        int count = 3;
        while (!pq.isEmpty() && count > 0) {
            result.add(sentenceList.get(pq.poll().idx));
            count--;
        }
        return result;
    }

    class TrieNode {
        TrieNode[] next;
        List<Pair> list;

        public TrieNode() {
            next = new TrieNode[100];
            list = new ArrayList();
        }

    }

    class Pair {
        int idx;
        int times;

        public Pair(int i, int t) {
            idx = i;
            times = t;
        }
    }
}

