package DataStructures.NewWork.LCArray;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AccountsMerge {
    public static void main(String[] args) {
        BlockingQueue queue=new LinkedBlockingQueue(4);
        String[][] words = {{"David", "David0@m.co", "David1@m.co"}, {"David", "David3@m.co", "David4@m.co"}, {"David", "David4@m.co", "David5@m.co"}, {"David", "David2@m.co", "David3@m.co"}, {"David", "David1@m.co", "David2@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for (String[] word : words) {
            List<String> list = new ArrayList<>();
            for (String s : word) {
                list.add(s);
            }
            accounts.add(list);
        }
        System.out.println(new AccountsMerge().accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList();
        Map<String, UserInfo> userInfoMap = new HashMap<>();
        List<UserInfo> userInfoList = new ArrayList<>();

        for(int i=0 ; i<accounts.size() ; i++){
            List<String> account = accounts.get(i);
            UserInfo userInfo = new UserInfo(account.get(0));
            userInfoList.add(userInfo);
            for(int j=1 ; j<account.size() ; j++){
                String email = account.get(j);
                if(userInfoMap.containsKey(email)){
                    UserInfo parent = findParent(userInfo);
                    UserInfo existingParent = findParent(userInfoMap.get(email));
                    parent.parent = existingParent;
                } else {
                    userInfo.emails.add(email);
                    userInfoMap.put(email, userInfo);
                }
            }
        }

        for(UserInfo userInfo : userInfoList){
            if(userInfo != userInfo.parent){
                UserInfo parent = findParent(userInfo);
                parent.emails.addAll(userInfo.emails);
            }
        }

        for(UserInfo user : userInfoList){
            if(user == user.parent){
                result.add(user.toList());
            }
        }

        return result;
    }

    private UserInfo findParent(UserInfo user){
        while(user.parent != user.parent.parent){
            user.parent = user.parent.parent;
        }
        return user.parent;
    }

    class UserInfo{
        String name;
        UserInfo parent;
        List<String> emails;

        UserInfo(String name){
            this.name = name;
            parent = this;
            emails = new ArrayList<>();
        }

        public List<String> toList(){
            List<String> list = new ArrayList<>();
            list.add(name);
            Collections.sort(emails);
            list.addAll(emails);
            return list;
        }
    }

//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        HashMap<String, User> map = new HashMap();
//        List<User> allUsers = new ArrayList();
//
//        for (List<String> account : accounts) {
//            User user = new User(account.get(0));
//            allUsers.add(user);
//            for (int i = 1; i < account.size(); i++) {
//                String email = account.get(i);
//                if (map.containsKey(email)) {
//                    User parent = findParent(user);
//                    User existedParent = findParent(map.get(email));
//                    parent.parent = existedParent;
//                } else {
//                    user.emails.add(email);
//                    map.put(email, user);
//                }
//            }
//        }
//
//        for (User user : allUsers) {
//            if (user.parent != user) {
//                User parent = findParent(user);
//                parent.emails.addAll(user.emails);
//            }
//        }
//
//        List<List<String>> result = new ArrayList();
//        for (User user : allUsers) {
//            if (user.parent == user) {
//                result.add(user.toList());
//            }
//        }
//
//        return result;
//    }
//
//    User findParent(User user) {
//        while (user.parent != user.parent.parent) {
//            user.parent = user.parent.parent;
//        }
//        return user.parent;
//    }
//
//    class User {
//        String name;
//        User parent;
//        List<String> emails;
//        User(String name) {
//            this.name = name;
//            parent = this;
//            emails = new ArrayList();
//        }
//
//        List<String> toList() {
//            List<String> result = new ArrayList();
//            result.add(name);
//            Collections.sort(emails);
//            result.addAll(emails);
//            return result;
//        }
//    }

//
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        Map<String, Integer> map = new HashMap();
//        int size = accounts.size();
//        int[] parents = new int[size];
////        int[] ranks = new int[size];
//        List<String>[] nodes = new List[size];
//
//        for (int i = 0; i < size; ++i) {
//            parents[i] = i;
//            List<String> emails = accounts.get(i);
//            nodes[i] = new ArrayList();
//
//            for (int j = 1; j < emails.size(); ++j) {
//                String email = emails.get(j);
//
//                if (map.containsKey(email)) {
//                    int root1 = getRoot(map.get(email), parents);
//                    int root2 = getRoot(i, parents);
//
//                    if (root1 != root2) {
//                        parents[root1] = root2;
//                    }
//                } else {
//                    nodes[i].add(email);
//                }
//                map.put(email, i);
//            }
//        }
//
//        for (int i = 0; i < size; ++i) {
//            if (i != parents[i]) {
//                nodes[getRoot(i, parents)].addAll(nodes[i]);
//            }
//        }
//
//        List<List<String>> result = new ArrayList();
//
//        for (int i = 0; i < size; ++i) {
//            if (parents[i] == i) {
//                List<String> emails = new ArrayList();
//                emails.add(accounts.get(i).get(0));
//                Collections.sort(nodes[i]);
//                emails.addAll(nodes[i]);
//                result.add(emails);
//            }
//        }
//
//        return result;
//    }
//
//    private int getRoot(int index, int[] parents) {
//        if (parents[index] == index) {
//            return index;
//        } else {
//            return parents[index] = getRoot(parents[index], parents);
//        }
//    }
}
