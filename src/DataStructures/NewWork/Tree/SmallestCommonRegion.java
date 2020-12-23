package DataStructures.NewWork.Tree;

import java.util.*;

public class SmallestCommonRegion {
    public static void main(String[] args) {
        String[][] regions = {{"zDkA","GfAj","lt"},{"GfAj","rtupD","og","l"},{"rtupD","IT","jGcew","ZwFqF"},{"og","yVobt","EjA","piUyQ"},{"IT","XFlc","W","rB"},{"l","GwQg","shco","Dub","KwgZq"},{"jGcew","KH","lbW"},{"KH","BZ","sauG"},{"yVobt","Aa","lJRmv"},{"BZ","v","zh","oGg","WP"},{"XFlc","Sn","ftXOZ"},{"sauG","If","nK","HHOr","yEH","YWMgF"},{"GwQg","Mfb","gr","S","nQ"},{"shco","xsUkW"},{"xsUkW","Cssa","TgPi","qx"},{"v","SAH","Rjr"},{"lt","Q","fWB","a","Wk","zpqU"},{"If","e","y","quEA","sNyV"},{"piUyQ","G","aTi"},{"Sn","rVIh","twv","pYA","Ywm"},{"zh","PWeEf"},{"Mfb","GEs","XjpeC","p"},{"GEs","oXMG","tNJYJ"},{"SAH","bmFhM"},{"bmFhM","SOvB","RWsEM","z"},{"SOvB","iD","pLGYN","Zqk"},{"Dub","PnGPY"},{"a","TekG","zp"},{"XjpeC","vK","aaO","D"},{"pLGYN","ldb"},{"oGg","x"},{"nQ","IOw"},{"Aa","wmYF"},{"Zqk","th"},{"ZwFqF","GDl"},{"th","JyOSt","ALlyw"},{"lbW","M"},{"yEH","UY","GIwLp"},{"JyOSt","i"},{"x","dclJ"},{"wmYF","xreBK"},{"PnGPY","Ev","lI"},{"ALlyw","jguyA","Mi"},{"oXMG","uqe"},{"sNyV","WbrP"}};

        List<List<String>> reg = new ArrayList<>();
        for(String[] arr : regions){
            List<String> list = new ArrayList<>(Arrays.asList(arr));
            reg.add(list);
        }
        System.out.println(new SmallestCommonRegion().findSmallestRegion(reg, "Quebec", "New York"));
    }

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> mapChildToParent = new HashMap<>();
        for(List<String> list : regions){
            for(int i=1; i<list.size() ; i++){
                mapChildToParent.put(list.get(i), list.get(0));
            }
        }

        while(region1 != region2){
            region1 = mapChildToParent.get(region1);
            region2 = mapChildToParent.get(region2);
        }

        return region1;
    }
}
