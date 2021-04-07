package DataStructures.NewWork.Design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignLeaderBoard {
    public static void main(String[] args) {
/**
 * ["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
 * [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
 * **/
        Leaderboard lb = new Leaderboard();
        lb.addScore(1, 73);
        lb.addScore(2, 56);
        lb.addScore(3, 39);
        lb.addScore(4, 51);
        System.out.println(lb.top(1));
        lb.reset(1);
        lb.reset(2);
        lb.addScore(2, 51);
        System.out.println(lb.top(3));
    }


}

class Leaderboard {

    TreeMap<Player, Integer> leaderBoard;
    Map<Integer, Player> map;

    public Leaderboard() {
        map = new HashMap<>();
        leaderBoard = new TreeMap<>(new Sorter());
    }

    public void addScore(int playerId, int score) {
        Player p = map.get(playerId);
        if (p == null) {
            p = new Player(playerId, score);
            leaderBoard.put(p, playerId);
            map.put(playerId, p);
        } else {
            p.score += score;
        }
    }

    public int top(int K) {
        int sum = 0;
        for (Player p : leaderBoard.keySet()) {
            sum += p.score;
            K--;
            if (K == 0) break;
        }
        return sum;
    }

    public void reset(int playerId) {
        Player p = map.get(playerId);
        leaderBoard.remove(p);
        map.remove(playerId);
    }

    class Player {
        int id, score;

        Player(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public boolean equals(Object o){
            Player p = (Player) o;
            return p.id == this.id
                    && p.score == this.score;
        }
    }

    class Sorter implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            if (o1.score > o2.score) return -1;
            return 1;
        }
    }
}
