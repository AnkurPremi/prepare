package DataStructures.NewWork.LCStrings;

import java.util.*;

public class DestinationCity {
    public static void main(String[] args) {
    String[][] arr = {{"jMgaf WaWA","iinynVdmBz"},{" QCrEFBcAw","wRPRHznLWS"},{"iinynVdmBz","OoLjlLFzjz"},{"OoLjlLFzjz"," QCrEFBcAw"},{"IhxjNbDeXk","jMgaf WaWA"},{"jmuAYy vgz","IhxjNbDeXk"}};
        List<List<String>> paths = new ArrayList<>();
        for(String[] path : arr){
            paths.add(new ArrayList<>(Arrays.asList(path[0], path[1])));
        }
        System.out.println(new DestinationCity().destCity(paths));
    }

    public String destCity(List<List<String>> paths) {
        String destination = "";
        Map<String, String> map  = new HashMap<>();
        String source = "";
        for(List<String> list : paths){
            source = list.get(0);
            destination = list.get(1);
            while(map.containsKey(destination)){
                source = destination;
                destination = map.get(destination);
            }
            map.put(source, destination);
        }
        return destination;
    }

}
