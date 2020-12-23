package DataStructures.Mock;

import java.util.*;

public class Equations {
    public static void main(String[] args) {
        List<List<String>> eq = new ArrayList(Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c")));
        List<List<String>> queries = new ArrayList(Arrays.asList(Arrays.asList("a","c"), Arrays.asList("b","a"), Arrays.asList("a","e"), Arrays.asList("a","a")));
        double[] values = {2.0,3.0};
        System.out.println(Arrays.toString(new Equations().calcEquation(eq, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Map<String, Double>> map = new HashMap();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            map.putIfAbsent(list.get(0), new HashMap());
            map.get(list.get(0)).put(list.get(1), values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            double result = findAns(map, q.get(0),  q.get(1));
            if(result < 0){
                result = findAns(map, q.get(1),  q.get(0));
                result = 1d/result;
            }
            ans[i] = result;
        }
        return ans;
    }

    private double findAns(Map<String, Map<String, Double>> map, String s, String lookingFor) {
        if (map.containsKey(s)) {
            if(s.equals(lookingFor)) return 1;
            if (map.get(s).containsKey(lookingFor)) {
                return map.get(s).get(lookingFor);
            } else {
                Map<String, Double> subMap = map.get(s);
                for (String s1 : subMap.keySet()) {
                    double ret = findAns(map, s1,  lookingFor);
                    if (ret > 0) {
                        return ret * subMap.get(s1);
                    }
                }
            }
        }
        return -1d;
    }

}
