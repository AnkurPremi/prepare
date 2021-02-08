package DataStructures.NewWork.graph;

import java.util.*;

public class SimilarSentence {
    public static void main(String[] args) {
//        String[] words1 = {"great", "acting", "skills"};
//        String[] words2 = {"fine", "drama", "talent"};
//        List<List<String>> list = new ArrayList();
//        list.add(Arrays.asList("great", "fine"));
////        list.add(Arrays.asList("fine", "good"));
//        list.add(Arrays.asList("drama", "acting"));
//        list.add(Arrays.asList("skills", "talent"));

        String[] words1 = {"great"};
        String[] words2 = {"great"};
        List<List<String>> list = new ArrayList();
        System.out.println(new SimilarSentence().areSentencesSimilar(words1, words2, list));
    }

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length, m = sentence2.length;
        if(m != n) return false;

        Map<String, List<String>> graph = createGraph(similarPairs);

        for(int i = 0 ; i < n ; i++){
            if(sentence1[i] == sentence2[i]) continue;
            if(graph.size() == 0) return false;
            if(!dfs(graph, sentence1[i], "", sentence2[i])){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<String, List<String>> graph, String currNode, String parent, String lookingFor){

        List<String> list = graph.get(currNode);
        if(list == null || list.isEmpty()) return false;

        for(String node : list){
            if(node.equals(parent)) continue;
            if(node.equals(lookingFor)) return true;
            if(dfs(graph, node, currNode, lookingFor)){
                return true;
            }
        }
        return false;
    }


    private Map<String, List<String>> createGraph(List<List<String>> similarPairs){
        Map<String, List<String>> graph = new HashMap();

        for(List<String> list : similarPairs){
            String s1 = list.get(0);
            String s2 = list.get(1);

            if(!graph.containsKey(s1)){
                graph.put(s1, new ArrayList());
            }

            if(!graph.containsKey(s2)){
                graph.put(s2, new ArrayList());
            }

            graph.get(s1).add(s2);
            graph.get(s2).add(s1);
        }

        return graph;
    }

//    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
//        if (words1.length != words2.length) return false;
//
//        Map<String, List<String>> map = new HashMap();
//
//        for (List<String> pair : pairs) {
//            if (!map.containsKey(pair.get(0))) {
//                map.put(pair.get(0), new ArrayList());
//            }
//
//            if (!map.containsKey(pair.get(1))) {
//                map.put(pair.get(1), new ArrayList());
//            }
//            map.get(pair.get(0)).add(pair.get(1));
//            map.get(pair.get(1)).add(pair.get(0));
//        }
//
//        Set<String> visited = new HashSet<>();
//        Set<String> inprogress = new HashSet<>();
//        Set<String> wordSet = new HashSet<>(Arrays.asList(words2));
//        for (String s : words1) {
//            if (!dfs(wordSet, visited, inprogress, s, map))
//                return false;
//        }
//        return true;
//    }
//
//    private boolean dfs(Set<String> words2, Set<String> visited, Set<String> inprogress, String w1, Map<String, List<String>> map) {
//        if (visited.contains(w1)) return true;
//        if (inprogress.contains(w1)) return false;
//
//        inprogress.add(w1);
//
//        for (int i = 0; i < map.get(w1).size(); i++) {
//            String s = map.get(w1).get(i);
//            if (words2.contains(s)) {
//                words2.remove(s);
//                visited.add(w1);
//                return true;
//            }
//            if(dfs(words2, visited, inprogress, s, map)) {
//                visited.add(w1);
//                return true;
//            }
//        }
//
//        return false;
//    }
}
