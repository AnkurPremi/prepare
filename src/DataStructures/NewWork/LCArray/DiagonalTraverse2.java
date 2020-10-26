package DataStructures.NewWork.LCArray;

import java.util.*;

public class DiagonalTraverse2 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4,5)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(8)));
        triangle.add(new ArrayList<>(Arrays.asList(9, 10, 11)));
        triangle.add(new ArrayList<>(Arrays.asList(12, 13, 14, 15, 16)));
        System.out.println(new DiagonalTraverse2().findDiagonalOrder(triangle));
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < nums.size(); i++) {
//            int k = 0;
//            for (int j = i; j >= 0; j--) {
//                if (k < nums.get(i - k).size()) {
//                    list.add(nums.get(i - k).get(k));
//                }
//                System.out.println(list);
//                k++;
//            }
//        }
//
//        for (int i = 1; i < nums.get(nums.size() - 1).size(); i++) {
//            int k = 0;
//            for (int j = nums.size() - 1; j >= 0; j--) {
//                if (k < nums.get(j - k).size()) {
//                    list.add(nums.get(j-k).get(i+k));
//                }
//                System.out.println(list);
//                k++;
//            }
//        }
////        return null;

        int totalElements = 0, writer = 0, diagonals = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int r = nums.size() - 1; r >= 0; --r) { // The values from the bottom rows are the starting values of the diagonals.
            for (int c = 0; c < nums.get(r).size(); ++c) {
                map.computeIfAbsent(r + c, x -> new ArrayList<>()).add(nums.get(r).get(c));
                diagonals = Math.max(diagonals, r + c);
                totalElements++;
            }
        }
        int[] ans = new int[totalElements];
        for (int key = 0; key <= diagonals; ++key) {
            List<Integer> value = map.get(key);
//            if (value == null) continue;
            for (int v : value) ans[writer++] = v;
        }
        return ans;
    }
}
