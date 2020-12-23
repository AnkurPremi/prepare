package DataStructures.NewWork.graph;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnections {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         https://youtu.be/aZXi1unBdJA
         We will use tarjan algorithm to find the bridges in the directed graph
         because when we remove bridges..we are not able to reach all nodes of graph
         Low link value os the minimum node value that can be reached from this node including itself
         **/


        boolean[] visited;
        int[] low;
        int[] id;
        List<List<Integer>> result;
        int time;
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {


            List<Integer>[] graph = new List[n];
            for(int i=0 ; i<n ; i++){
                graph[i] = new ArrayList();
            }
            for(int i=0 ; i<connections.size() ; i++){
                List<Integer> conn = connections.get(i);
                graph[conn.get(0)].add(conn.get(1));
                graph[conn.get(1)].add(conn.get(0));
            }

            this.visited = new boolean[n];
            this.low = new int[n];
            this.id = new int[n];
            this.result = new ArrayList();

            for(int i=0 ; i<n ; i++){
                if(!visited[i]){
                    dfs(graph, i, -1);
                }
            }
            return result;
        }

        private void dfs(List<Integer>[] graph, int node, int parent){
            visited[node] = true;
            low[node] = id[node] = ++time;

            for(int i=0 ; i< graph[node].size() ; i++){
                int v = graph[node].get(i);
                if(v == parent) continue;
                if(!visited[v]){

                    dfs(graph, v, node);

                    low[node] = Math.min(low[node], low[v]);
                    if(id[node] < low[v]){
                        List<Integer> list = new ArrayList();
                        list.add(node);
                        list.add(v);
                        result.add(list);
                    }
                } else{
                    low[node] = Math.min(low[node], id[v]);
                }
            }

        }
    }
}
