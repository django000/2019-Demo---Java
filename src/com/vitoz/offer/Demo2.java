package com.vitoz.offer;

public class Demo2 {
    public static void main(String[] args) {
        SingletonA singletonA = SingletonA.getInstance();
        SingletonB singletonB = SingletonB.getInstance();
        SingletonC singletonC = SingletonC.getInstance();
        SingletonD singletonD = SingletonD.getInstance();
        SingletonE singletonE = SingletonE.INSTANCE;
    }
}

class SingletonA{
    private SingletonA(){};
    private static final SingletonA instance = new SingletonA();
    public static SingletonA getInstance(){
        return instance;
    }
}

class SingletonB{
    private SingletonB(){};
    private static volatile SingletonB instance = null;
    public static SingletonB getInstance(){
        if (instance == null){
            synchronized (SingletonB.class){
                if (instance == null){
                    instance = new SingletonB();
                }
            }
        }
        return instance;
    }
}

class SingletonC{
    static {
        instance = new SingletonC();
    }
    private SingletonC(){};
    private static SingletonC instance = null;
    public static SingletonC getInstance(){
        return instance;
    }
}

class SingletonD{
    private SingletonD(){};
    public static SingletonD getInstance(){
        return SingletonHolder.instance;
    }
    private static class SingletonHolder{
        private static final SingletonD instance = new SingletonD();
    }
}

enum SingletonE{
    INSTANCE;
}