package Interview;

import Interview.singleton.SingletonEnum;

import java.util.List;

public class Mover {
    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        System.out.println(instance.getData());

    }
}
