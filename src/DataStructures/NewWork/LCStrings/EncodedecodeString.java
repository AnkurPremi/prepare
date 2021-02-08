package DataStructures.NewWork.LCStrings;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodedecodeString {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String s = codec.encode(Arrays.asList("abddadjhaioshdaso", "je2io3uhfoiqjqc>.AD,ASQMD", "NAIHQIWNDQIND8QY3428NFH10U9I0I   IWJW U W9RUW  ,,,..,/..//;'"));
        System.out.println(codec.decode(s));
    }


}

class Codec {

    int idx = 0;

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String s : strs){
            for(int i=0 ; i<s.length() ; i++){
                int val = s.charAt(i) - ' ';
                builder.append(val).append(",");
            }
            builder.append("|");
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        addData(s, result, new StringBuilder());
        return result;
    }

    private void addData(String s, List<String> list, StringBuilder builder){
        if(idx == s.length()) return;

        while(s.charAt(idx) != '|'){
            int num = 0;
            while(s.charAt(idx) != ','){
                num = num * 10 + s.charAt(idx) - '0';
                idx++;
            }
            builder.append((char)(num + ' '));
            idx++;
        }
        idx++;
        list.add(builder.toString());
        builder.setLength(0);
        addData(s, list, builder);
    }
}