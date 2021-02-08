package DataStructures.NewWork.Misc;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};
//        for(int i= 0 ; i<100 ; i++)
            System.out.println(new TopKFrequentWords().topKFrequent(words, 14));
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        WordInfo[] arr = new WordInfo[map.size()];
        int writer = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr[writer++] = new WordInfo(entry.getKey(), entry.getValue());
        }

        //shuffle
//        shuffle(arr);
        quickSelect(arr, k - 1);

        Arrays.sort(arr, 0, k, (a, b) ->{
            return a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count;
        });

        List<String> result = new ArrayList<>();
        for(int i=0 ; i<k ; i++){
            result.add(arr[i].word);
        }
        return result;
    }

    private void quickSelect(WordInfo[] arr, int k) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int pIndex = partition(arr, start, end);
            if (pIndex == k) return;
            else if (pIndex > k) end = pIndex - 1;
            else start = pIndex + 1;
        }

    }

    private int partition(WordInfo[] arr, int start, int end) {
        WordInfo pivot = arr[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i].count > pivot.count) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }


    private void shuffle(WordInfo[] arr) {
        Random random = new Random();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int r = random.nextInt(n);
            swap(arr, i, r);
        }
    }

    private void swap(WordInfo[] arr, int i, int j) {
        WordInfo temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    class WordInfo {
        String word;
        int count;

        public WordInfo(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
