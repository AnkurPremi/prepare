package DataStructures.DP;

public class HappyStringV2 {
    public static void main(String[] args) {
        System.out.println(new HappyStringV2().strWithout3a3b(1,1));
    }
    public String strWithout3a3b(int a, int b) {
        if(a == 0 && b != 0) return b >= 2 ? "bb" : "b" ;
        if(a != 0 && b == 0) return a >= 2 ? "aa" : "a" ;

        Pair maxPair = a > b ? new Pair('a', a) : new Pair('b', b);
        Pair minPair = a < b ? new Pair('a', a) : new Pair('b', b);
        StringBuilder builder = new StringBuilder();
        while(true){
            if(maxPair.count >= 2){
                builder.append(maxPair.c).append(maxPair.c);
                maxPair.count -= 2;
            }else{
                builder.append(maxPair.c);
                maxPair.count -= 1;
            }

            if(minPair.count >=2 && minPair.count > maxPair.count){
                builder.append(minPair.c).append(minPair.c);
                minPair.count -= 2;
            } else{
                builder.append(minPair.c);
                minPair.count -= 1;
            }

            if(minPair.count <=0 || maxPair.count <= 0) break;
            minPair = minPair.count >= maxPair.count ? maxPair : minPair;
            maxPair = minPair.count < maxPair.count ? maxPair : minPair;
        }

        if(minPair.count > 0){
            if(builder.charAt(builder.length()-1) == minPair.c){
                if(builder.length() >2 && builder.charAt(builder.length()-2) != maxPair.c)
                    builder.append(minPair.c);
            }else{
                if(minPair.count >=2)
                    builder.append(minPair.c).append(minPair.c);
                else
                    builder.append(minPair.c);
            }
        }else if(maxPair.count >0){
            if(builder.charAt(builder.length()-1) == maxPair.c){
                if(builder.length() >2 && builder.charAt(builder.length()-2) != maxPair.c)
                    builder.append(maxPair.c);
            }else{
                if(maxPair.count >=2)
                    builder.append(maxPair.c).append(maxPair.c);
                else
                    builder.append(maxPair.c);
            }
        }
        return builder.toString();
    }

    class Pair{
        char c;
        int count;
        Pair(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
}
