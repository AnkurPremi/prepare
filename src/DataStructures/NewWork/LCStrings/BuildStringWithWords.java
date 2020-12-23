package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class BuildStringWithWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(new BuildStringWithWords().findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        TrieNode root = buildTrie(words);
        TrieNode node = root;
        int l = 0, r = 0, count = words.length, countHere = 0;
        List<Integer> result = new ArrayList();

        while (r < s.length()) {
            if (node.next[s.charAt(r) - 'a'] != null) {
                while (node.next[s.charAt(r) - 'a'] != null) {
                    node = node.next[s.charAt(r) - 'a'];
                    r++;
                }

                if (node.isWord) {
                    node.isUsed = true;
                    if (node.count > 0) {
                        countHere++;
                        if (countHere == count) {
                            result.add(l);
                        }
                        node.count--;
                        node = root;
                    } else {
                        //contract the window from left by moving left to right and replenishing the words
                        TrieNode temp = root;
                        while (temp.next[s.charAt(l) - 'a'] != null) {
                            temp = temp.next[s.charAt(l) - 'a'];
                            l++;
                            if (temp.isUsed && temp.isWord) {
                                countHere--;
                                temp.isUsed = false;
                            } else if (temp == node && node.isUsed) {
                                countHere++;
                                if (countHere == count) {
                                    result.add(l);
                                }
                                node.isUsed = false;
                                break;
                            } else if (temp.next[s.charAt(l) - 'a'] == null) {
                                temp = root;
                            }
                        }
                    }

                } else {
                    l = r;
                    node = root;
                }
            } else {

                TrieNode temp = root;
                while (l <= r) {
                    temp = temp.next[s.charAt(l) - 'a'];
                    l++;
                    if (temp.next[s.charAt(l) - 'a'] == null) {
                        if (temp.isUsed && temp.isWord) {
                            countHere--;
                            temp.isUsed = false;
                            r++;
                            break;
                        }
                        temp = root;
                    }
                    else if (temp.isUsed && temp.isWord) {
                        countHere--;
                        temp.isUsed = false;
                        r++;
                        break;
                    }
                }

            }

        }

        return result;

    }


    //build Trie with words
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                if (node.next[word.charAt(i) - 'a'] == null) {
                    node.next[word.charAt(i) - 'a'] = new TrieNode();
                }
                node = node.next[word.charAt(i) - 'a'];
            }
            node.isWord = true;
            node.count++;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
        int count;
        boolean isUsed;
    }
}
