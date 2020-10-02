package DataStructures.HashTable;

public class MinBaloons {
    public static void main(String[] args) {
        System.out.println(new MinBaloons().maxNumberOfBalloons("nlaebolko"));
    }

    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        if(n < 7) return 0;
        int[] map = new int[26];
        for(char c : text.toCharArray()){
            map[c-'a']++;
        }
        n = Math.min(n, map['b'-'a']);
        n = Math.min(n, map['a'-'a']);
        n = Math.min(n, map['l'-'a']/2);
        n = Math.min(n, map['o'-'a']/2);
        n = Math.min(n, map['n'-'a']);

        return n;
    }
}
