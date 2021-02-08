package DataStructures.NewWork.BitManipulation;

public class DecodeXORedPermutation {
    public static void main(String[] args) {
        int[] encode = {3, 1};
        System.out.println(new DecodeXORedPermutation().decode(encode));
    }

    public int[] decode(int[] encoded) {
        //encoded = a1^a2  a2^a3  a3^a4 ...
        //XOR of first n = a1^a2^a3^a4....   (1^2^3^4...)

        //if we take xor of all odd indices (1, 3, 5...) with XOR of first N (1^2^3^4...)
        //we will get the first element a1
        // (a2^a3) ^ (a4^a5) ^ (a6^a7) ... ^ 1^2^3^4...
        //ans is a1 (rest will canceled)

        int n = encoded.length;
        int cur = 0;
        for(int i = 1 ; i < n ; i += 2){
            cur ^= encoded[i];
        }

        int allXOR = 0;
        for(int i = 1 ; i <= n + 1 ; i++){
            allXOR ^= i;
        }

        int first = cur ^ allXOR;
        int[] result = new int[n + 1];
        result[0] = first;

        for(int i = 1 ; i <= n ; i++){
            result[i] = encoded[i - 1] ^ result[i - 1];
        }

        return result;
    }
}
