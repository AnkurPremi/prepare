package Interview.singleton;

import java.io.Serializable;

public class SingletonNormal implements Serializable {

    private static SingletonNormal instance = null;

    private SingletonNormal(){}

    public static SingletonNormal getInstance(){
        //double checked locking
        //when 2 thread comes and one is waiting at Synchronized block.. another creates object and goes out....
        // waiting thread will also create object.. if we are again not checking for null
        if(instance == null){
            synchronized (SingletonNormal.class){
                if(instance == null){
                    instance = new SingletonNormal();
                }
            }
        }
        return instance;
    }

    protected Object readResolve(){
        return getInstance();
    }
}
