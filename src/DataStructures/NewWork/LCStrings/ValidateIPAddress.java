package DataStructures.NewWork.LCStrings;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String s = "092.168.1.0";
        System.out.println(new ValidateIPAddress().validIPAddress(s));
    }

    public String validIPAddress(String IP) {
        int count = firstPartCount(IP);
        if(count == 4)
            return validateIPv6(IP);
        else if(count == 3)
            return validateIPv4(IP);
        return "Neither";
    }

    private String validateIPv4(String ip){

        int idx = 0;
        int total = 0;
        while(idx < ip.length()){
            if(ip.charAt(idx) == '0') return "Neither";
            int num = 0;
            while(idx < ip.length() && ip.charAt(idx) != '.'){
                if(Character.isDigit(ip.charAt(idx)))
                    num = num*10 + ip.charAt(idx) - '0';
                else
                    return "Neither";

                idx++;
            }
            if(num > 0 && num < 256 && ++total < 5){
                idx++;
                continue;
            }
            else
                return "Neither";
        }

        return total == 4 ? "IPv4" : "Neither";
    }

    private String validateIPv6(String ip){
        int total = 0;
        int idx = 0;
        int countHere = 0;
        while(idx < ip.length()){
            countHere = 0;
            while(idx < ip.length() && ip.charAt(idx) != ':'){
                char c = ip.charAt(idx);
                if(Character.isDigit(c) || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F'){
                    countHere++;
                }
                else{
                    return "Neither";
                }
                idx++;
            }
            if(++total < 7 && countHere == 4)
                continue;
            else return "Neither";
        }

        return total == 6 ? "IPV6" : "Neither";
    }

    private int firstPartCount(String IP){
        int count = 0;
        int idx = 0;
        while(idx < IP.length() && (IP.charAt(idx) != '.' && IP.charAt(idx) != ':')) {
            count++;
            idx++;
        }
        return count;
    }
}
