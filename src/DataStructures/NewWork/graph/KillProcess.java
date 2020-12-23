package DataStructures.NewWork.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            Map<Integer, List<Integer>> map = new HashMap();

            for (int i = 0; i < ppid.size(); i++) {
                if (!map.containsKey(ppid.get(i))) {
                    map.put(ppid.get(i), new ArrayList());
                }
                map.get(ppid.get(i)).add(pid.get(i));
            }

            List<Integer> result = new ArrayList();

            if (!map.containsKey(kill)) {
                result.add(kill);
            } else {
                result.add(kill);
                helper(map.get(kill), result, map);
            }
            return result;
        }

        private void helper(List<Integer> list, List<Integer> result, Map<Integer, List<Integer>> map) {
            for (int i = 0; i < list.size(); i++) {
                int val = list.get(i);
                result.add(val);
                if (map.containsKey(val)) {
                    helper(map.get(val), result, map);
                }
            }
        }
    }

}
