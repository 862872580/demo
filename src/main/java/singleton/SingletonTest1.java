package singleton;

import org.junit.Test;

//饿汉式
class Singleton1{
    private static final Singleton1 singleton1 = new Singleton1();

    private Singleton1(){

    }

    static public Singleton1 getSingleton1() {
        return singleton1;
    }

}

public class SingletonTest1 {

    @Test
    public void doSome(){
        Singleton1 s1 = Singleton1.getSingleton1();
        Singleton1 s2 = Singleton1.getSingleton1();
        System.out.println(s1==s2);
    }
}
