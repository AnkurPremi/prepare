package Interview.FactoryPattern;

public class FactoryHelper {
    public static void main(String[] args) {
        CommonRepo repo = getInstance("first");
        repo.printData(repo.getData());
    }

    public static CommonRepo getInstance(String name){
        switch (name){
            case "first":
                return new FirstRepo();
            case "second":
                return new SecondRepo();
            default:
                return null;
        }
    }
}
