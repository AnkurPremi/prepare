package DataStructures.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.id = 1;
        e.importance = 5;
        e.subordinates = Arrays.asList(2,3);
        Employee e1 = new Employee();
        e1.id = 2;
        e1.importance = 3;
        Employee e2 = new Employee();
        e2.id = 3;
        e2.importance = 3;
        List<Employee> employees = Arrays.asList(e,e1,e2);
        System.out.println(new EmployeeImportance().getImportance(employees, 1));
    }

    public int getImportance(List<Employee> list, int id) {
        Map<Integer, Integer> map = new HashMap<>();
        getImportance(list, 0, id, map);
        return map.get(id);
    }

    public int getImportance(List<Employee> list, int idx, int id, Map<Integer, Integer> map) {
        if (idx == list.size()) return 0;
        if (map.containsKey(id)) return map.get(id);
        for (int i = idx; i < list.size(); i++) {
            Employee e = list.get(i);
            int imp = e.importance;
            if (e.subordinates != null && !e.subordinates.isEmpty()) {
                for (Integer sub : e.subordinates) {
                    imp += getImportance(list, idx + 1, sub, map);
                }
            }
            map.put(e.id, imp);
            if (e.id == id) {
                return map.get(id);
            }
        }
        return map.get(id);
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
