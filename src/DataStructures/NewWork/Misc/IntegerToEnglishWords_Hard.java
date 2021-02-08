package DataStructures.NewWork.Misc;

public class IntegerToEnglishWords_Hard {
    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords_Hard().numberToWords(12345678));
    }

    final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] THOUSANDS = {"Billion", "Million", "Thousand", ""};
    final int[] radix = {1000000000, 1000000, 1000, 1};


    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i<radix.length ; i++){
            if(num / radix[i] == 0) continue; //number is smaller than this radix value
            builder.append(helper(num / radix[i])).append(THOUSANDS[i]).append(' ');
            num %= radix[i];
        }
        return builder.toString().trim();
    }

    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return LESS_THAN_20[num] + " ";
        else if(num < 100) return TENS[num / 10] + " " + helper(num % 10);
        else return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }






















//    public String numberToWords(int num) {
//        if (num == 0) return "Zero";
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < radix.length; i++) {
//            if (num / radix[i] == 0) continue;
//            sb.append(trans(num / radix[i])).append(THOUSANDS[i]).append(' ');
//            num %= radix[i];
//        }
//        return sb.toString().trim();
//    }
//
//    private String trans(int num) {
//        if (num == 0) return "";
//        if (num < 20) return LESS_THAN_20[num] + " ";
//        if (num < 100) return TENS[num / 10] + " " + trans(num % 10);
//        return LESS_THAN_20[num / 100] + " Hundred " + trans(num % 100);
//    }
}
