package DataStructures.strings;

import java.util.HashMap;
import java.util.Map;

public class Unique_Email_Addresses {
    public static void main(String[] args) {
        String[] emails = {"test.email@leetcode.com","test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(new Unique_Email_Addresses().numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        if(emails.length == 1) return 1;
        Map<String, Boolean> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for(String emailId : emails){
            if(map.containsKey(emailId)) continue;
            builder.setLength(0);
            for(int i=0;i<emailId.length() ; i++){
                char c = emailId.charAt(i);
                if(c == '+'){
                    while(emailId.charAt(i) != '@'){
                        i++;
                    }
                    builder.append(emailId.substring(i));
                    break;
                }
                else if(c == '.') continue;
                else if(c == '@') {
                    builder.append(emailId.substring(i));
                    break;
                }
                builder.append(c);
            }
            map.put(builder.toString(), true);
        }
        return map.size();
    }
}
