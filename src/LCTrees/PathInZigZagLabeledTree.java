package LCTrees;

import java.util.ArrayList;
import java.util.List;

public class PathInZigZagLabeledTree {
    public static void main(String[] args) {
        System.out.println(new PathInZigZagLabeledTree().pathInZigZagTree(26));
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        String num = Integer.toBinaryString(label);
        boolean oddLenStr = num.length() % 2 != 0;
        int level = 2;
        result.add(1);
        for (int i = 1; i < num.length() - 1; i++) {
            if ((!oddLenStr && level % 2 == 0) || (oddLenStr && level % 2 != 0)) {
                result.add(getNumberFromStr(num, i));
            } else if ((oddLenStr && level % 2 == 0) || (!oddLenStr && level % 2 != 0)) {
                result.add(getNumFromInvertedString(num, i));
            }
            level++;
        }
        result.add(label);
        return result;
    }

    private Integer getNumberFromStr(String s, int i) {
        return Integer.parseInt(s.substring(0, i + 1), 2);
    }

    private Integer getNumFromInvertedString(String s, int i) {
        StringBuilder builder = new StringBuilder();
        builder.append('1');
        for (int j = 1; j <= i; j++) {
            if (s.charAt(j) == '0')
                builder.append('1');
            else
                builder.append('0');
        }
        return Integer.parseInt(builder.toString(), 2);
    }
}
