package singleton;

import org.junit.Test;

//懒汉式
class Singleton{
    private static Singleton singleton;

    public Singleton() {
    }

    static public Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}

public class SingletonTest {

    @Test
    public void doSome(){
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton==singleton1);
    }
}
