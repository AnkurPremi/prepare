package Interview.singleton;

public class SingletonBillPugh {

    private SingletonBillPugh() {
    }

    private static final class SingletonBillPughHelper {
        private static final SingletonBillPugh singletonBillPugh = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return SingletonBillPughHelper.singletonBillPugh;
    }

}
