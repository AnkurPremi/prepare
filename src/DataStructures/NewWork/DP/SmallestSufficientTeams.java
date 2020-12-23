package DataStructures.NewWork.DP;

import java.util.*;

public class SmallestSufficientTeams {
    public static void main(String[] args) {
        String[] arr = {"algorithms","math","java","reactjs","csharp","aws"};
        List<List<String>> l = new ArrayList<>(Arrays.asList(Arrays.asList("algorithms","math","java"), Arrays.asList("algorithms","math","reactjs"), Arrays.asList("java","csharp","aws")
                , Arrays.asList("reactjs","csharp"), Arrays.asList("csharp","math"), Arrays.asList("java","aws")));
        System.out.println(new SmallestSufficientTeams().smallestSufficientTeam(arr, l));
    }

    List<Integer> sol = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> idx = new HashMap<>();
        int n = 0;
        for (String s : req_skills) idx.put(s, n++);///skills are represented by 0, 1, 2....
        int[] pe = new int[people.size()];
        for (int i = 0; i < pe.length; i++) {
            for (String p : people.get(i)) {
                int skill = idx.get(p);
                pe[i] += 1 << skill;
            }
        } // each person is transferred to a number, of which the bits of 1 means the guy has the skill
        search(0, pe, new ArrayList<Integer>(), n);
        int[] ans = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) ans[i] = sol.get(i);
        return ans;
    }

    public void search(int cur, int[] pe, List<Integer> onesol, int n) {
//        System.out.println("skillSet - "+Integer.toBinaryString(cur));
        if (cur == (1<<n) - 1) {  // when all bits are 1, all skills are coverred
            if (sol.size() == 0 || onesol.size() < sol.size()) {
                sol = new ArrayList<>(onesol);
            }
            return;
        }
        if (sol.size() != 0 && onesol.size() >= sol.size()) return;    //pruning
        int zeroBit = 0;
        while (((cur>>zeroBit)&1) == 1) zeroBit++;
        for (int i = 0; i < pe.length; i++) {
            int per = pe[i];
//            System.out.println("person - "+Integer.toBinaryString(per));
            if (((per>>zeroBit)&1) == 1) {
                onesol.add(i); // when a person can cover a zero bit in the current number, we can add him
                search(cur|per, pe, onesol, n);
                onesol.remove(onesol.size() - 1);  //search in a backtracking way
            }
        }
    }

}
