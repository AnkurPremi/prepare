package Interview.FactoryPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstRepo extends CommonRepo {
    @Override
    public List<String> getData() {
        return new ArrayList<>(Arrays.asList("first"));
    }
}
