package DataStructures.Mock;

import java.util.ArrayList;
import java.util.List;

public class PackWords {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(new PackWords().fullJustify(words, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList();

        int l = 0, r = 0;
        int len = 0;
        StringBuilder builder = new StringBuilder();
        int wordCount = 0;
        while (r < words.length) {
            if (len + words[r].length() + wordCount - 1 >= maxWidth) {  // currLen + newLen + minSpace > totalAllowed
                // if(len + words[r].length() + wordCount-1 >= maxWidth
                int spaceBlocks = wordCount - 1;
                if(spaceBlocks == 0){
                    //handle case
                }
                int actualSpace = (maxWidth - len)/ spaceBlocks;
                int newSpace = 0;
                if (actualSpace % spaceBlocks != 0) {
                    newSpace = actualSpace % spaceBlocks;
                }

                while (newSpace > 0) {
                    builder.append(words[l]);
                    int space = actualSpace + 1;
                    newSpace--;
                    while (space > 0) {
                        builder.append(" ");
                        space--;
                    }
                    l++;
                }

                while (l < r) {
                    builder.append(words[l]);
                    if (++l < r) {
                        int space = actualSpace;
                        while (space > 0) {
                            builder.append(" ");
                            space--;
                        }
                    }
                }
                result.add(builder.toString());
                builder.setLength(0);
                len = 0;
                wordCount = 0;
            }
            len += words[r].length();
            wordCount++;
            r++;
        }

        return result;
    }
}
