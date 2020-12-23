package DataStructures.Trees;

import java.util.*;

public class KIllProcess {
    public static void main(String[] args) {
        List<Integer> pid = new ArrayList<>(Arrays.asList(1, 3, 10, 5));
        List<Integer> ppid = new ArrayList<>(Arrays.asList(3, 0, 5, 3));
        System.out.println(new KIllProcess().killProcess(pid, ppid, 5));
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < pid.size(); i++) {
            if (!map.containsKey(ppid.get(i)))
                map.put(ppid.get(i), new ArrayList());

            map.get(ppid.get(i)).add(pid.get(i));

            if(!map.containsKey(pid.get(i)))
                map.put(pid.get(i), new ArrayList());
        }

        Deque<Integer> dq = new LinkedList();
        dq.addLast(kill);
        result.add(kill);

        while (!dq.isEmpty()) {
            List<Integer> tempList = map.get(dq.pollFirst());
            if (tempList.isEmpty()) continue;
            for (int i : tempList) {
                result.add(i);
                dq.addLast(i);
            }
        }

        return result;
    }
}
