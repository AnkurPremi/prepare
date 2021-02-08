package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class TextJustify {
    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        System.out.println(new TextJustify().fullJustify(words, 16));
    }

    public List<String> fullJustify(String[] words, int L) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int idx = 0;

        while(idx < words.length){
            int count = words[idx].length();
            int next = idx + 1;
            while(next < words.length){
                if(count + words[next].length() + 1 > L) break;
                count += words[next].length() + 1;
                next++;
            }

            builder.setLength(0);
            int diff = next - idx - 1;
            builder.append(words[idx]);

            //if only 1 word or last line
            if(diff == 0 || next == words.length){
               for(int i = idx + 1 ; i < next ; i++){
                   builder.append(" ").append(words[i]);
               }
               for(int i = builder.length() ; i < L ; i++){
                   builder.append(" ");
               }
            } else{
                int spaces = (L - count) / diff;
                int extra = (L - count) % diff;
                for(int j = idx + 1 ; j < next ; j++) {
                    for (int i = 0; i < spaces; i++) {
                        builder.append(" ");
                    }
                    if (extra > 0) {
                        builder.append(" ");
                        extra--;
                    }
                    builder.append(words[j]);
                }
            }
            ans.add(builder.toString());
            idx = next;
        }
        return ans;
    }

    public List<String> fullJustify1(String[] words, int L) {
        List<String> lines = new ArrayList<String>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                //plus one for the space, if its a perfect fit it will fit
                count += 1 + words[last].length();
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);

            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index+1; i < last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index+1; i < last; i++) {
                    for(int k=spaces; k > 0; k--) {
                        builder.append(" ");
                    }
                    if(r > 0) {
                        builder.append(" ");
                        r--;
                    }
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }
}
