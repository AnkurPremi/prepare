package DataStructures.Instacart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardsGame {
    public static void main(String[] args) {
        /**
         * Prefix : -, +, =
         * Letter: A, B, C
         * Count: 1, 2, 3
         * **/
        String s = "-A -B -C +C -CC =CCC";
        CardsGame game = new CardsGame();
        System.out.println(game.findCards(s));
    }

    Map<Integer, Map<Integer, List<Character>>> map;
    StringBuilder builder;

    private String findCards(String s){
        map = new HashMap<>();
        builder = new StringBuilder();

        prepareMap(s);

        //three of same type
        for(int i = 1 ; i <= 3 ; i++){
            for(int j = 1; j <= 3 ; j++) {
                if (threeOfSameType(i, j)) {
                    return builder.toString();
                }
            }
        }


        return s;
    }

    private boolean threeOfSameType(int c, int count){
        if(!map.containsKey(c)) return false;
        if(!map.get(c).containsKey(1)) return false;
        if(map.get(c).get(count).size() < 3) return false;

        List<Character> list = map.get(c).get(count);
        for(char ch : list){
            builder.append(getChar(c)).append(ch).append(' ');
        }
        builder.setLength(builder.length() - 1);
        return true;
    }

    private void prepareMap(String s){
        int idx = 0;
        int count = 0;
        while(idx < s.length()){
            char c = s.charAt(idx);
            if(isPrefix(c)){
                idx++;
                char ch = s.charAt(idx);
                while(idx < s.length() && s.charAt(idx) == ch){
                    count++;
                    idx++;
                }
                addToMap(count, c, ch);
                count = 0;
            }
            idx++;
        }
    }

    private void addToMap(int count, char c, char letter){
        int charType = getCharType(c);
        if(!map.containsKey(charType)){
            map.put(charType, new HashMap<>());
        }
        if(!map.get(charType).containsKey(count)){
            map.get(charType).put(count, new ArrayList<>());
        }
        map.get(charType).get(count).add(letter);
    }

    private boolean isPrefix(char c){
        return c == '-' || c == '+' || c == '=';
    }

    private int getCharType(char c){
        if(c == '-') return 1;
        else if(c == '-') return 2;
        return 3;
    }

    private char getChar(int c){
        if(c == 1) return '-';
        else if(c == 2) return '+';
        return '=';
    }
}
