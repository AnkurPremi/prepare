package DataStructures.NewWork.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteTreeNodes {
    public static void main(String[] args) {
        int nodes = 7;
        int[] parent = {-1, 0, 0, 1, 2, 2, 2}, value = {1, -2, 4, 0, -2, -1, -1};
        System.out.println(new DeleteTreeNodes().deleteTreeNodes(nodes, parent, value));
    }

    int[] value;
    Map<Integer, List<Integer>> parentToChild;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        this.parentToChild = new HashMap();
        this.value = value;

        for (int i = 0; i < parent.length; i++) {
            parentToChild.putIfAbsent(parent[i], new ArrayList());
            parentToChild.get(parent[i]).add(i);
        }

        int[] ans = doDFS(0);
        return ans[1];
    }

    private int[] doDFS(int root) {
        int sum = value[root];
        int nodeCnt = 1;

        List<Integer> list = parentToChild.get(root);
        if (list != null && !list.isEmpty()) {
            for (int childNode : list) {
                int[] subTreeInfo = doDFS(childNode);
                sum += subTreeInfo[0];
                nodeCnt += subTreeInfo[1];
            }
        }

        if (sum == 0) nodeCnt = 0;
        return new int[]{sum, nodeCnt};
    }
}
