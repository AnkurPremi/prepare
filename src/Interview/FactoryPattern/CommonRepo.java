package Interview.FactoryPattern;

import java.util.List;

public abstract class CommonRepo {

    public abstract List<String> getData();

    public void printData(List<String> list){
        if(list == null) return;
        for(String s: list){
            System.out.println(s);
        }
    }
}
