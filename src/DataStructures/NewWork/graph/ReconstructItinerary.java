package DataStructures.NewWork.graph;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        String[][] arr = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> accounts = new ArrayList<>();
        for (String[] word : arr) {
            List<String> list = new ArrayList<>();
            for (String s : word) {
                list.add(s);
            }
            accounts.add(list);
        }
        System.out.println(new ReconstructItinerary().findItinerary(accounts));
    }


    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Destination>> paths = new HashMap();

        for(int i=0 ; i<tickets.size() ; i++){
            List<String> ticket = tickets.get(i);
            paths.putIfAbsent(ticket.get(0), new ArrayList());
            paths.get(ticket.get(0)).add(new Destination(ticket.get(1), i));
        }

        for(Map.Entry<String, List<Destination>> entry : paths.entrySet()){
            Collections.sort(entry.getValue(), (a, b) ->{
                return a.name.compareTo(b.name);
            });
        }

        List<String> ans = new ArrayList();
        ans.add("JFK");
        dfs(paths, new HashSet(), ans, "JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(Map<String, List<Destination>> paths, Set<Integer> visited, List<String> ans, String src){

        for(Destination dest : paths.get(src)){
            if(visited.contains(dest.idx)) continue;
            visited.add(dest.idx);
            ans.add(dest.name);
            dfs(paths, visited, ans, dest.name);
        }

    }

    class Destination{
        String name;
        int idx;

        Destination(String name, int idx){
            this.name = name;
            this.idx = idx;
        }
    }
}
