package DataStructures.NewWork.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StronglyConnectedComponents_KosarajusAlgo {
    public static void main(String[] args) {

    }

    //given a list of airports, a start airport ("JFK") and a lit of different routes ("DEL" -> "EWR", "SEA" -> "PHL")
    //airline system wants to add new flight routes to the current routes.. so that a passenger can reach all the airports starting from  "start" point
    //Routes can be represented by Directed graph
    //Step 1 - Find Strongly connected components by Kasaraju's algo
    //Step 2 - compress the graph
    //Step 3 - create "who" array
    //Step 4 - Find in-degree of new compressed graph
    //Step 5 - To check if there are any vertices with in-degree 0...which means we need to add a route to this airport from "start" point...to enable travel to all the cities
    //Bring all the nodes as part of Strongly Connected components
    private int countNewEdgesToBeAdded(List<List<String>> routes, String start, List<String> airports) {

        int n = airports.size();

        //convert string airports to ints
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(airports.get(i), i);
        }

        //create adjacency list
        List[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList();

        for(List<String> list : routes){
            graph[map.get(list.get(0))].add(map.get(list.get(1)));
        }

        //create reverse adj list

        return 0;
    }
}
