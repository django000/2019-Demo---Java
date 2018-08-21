package com.vitoz.basic.models;

public class Singleton {
    public static void main(String[] args) {
        SingletonA singletonA = SingletonA.getTon();
        singletonA.name = "hello";
        SingletonA singletonA1 = SingletonA.getTon();
        singletonA1.name = "john";
        System.out.println(singletonA.name);

        SingletonB singletonB = SingletonB.getTon();
        singletonB.name = "hi";
        SingletonB singletonB1 = SingletonB.getTon();
        singletonB1.name = "snow";
        System.out.println(singletonB.name);
    }
}

class SingletonA{
    private SingletonA(){}
    private static final SingletonA singletonA = new SingletonA();
    static SingletonA getTon(){
        return singletonA;
    }
    String name;
}

class SingletonB{
    private SingletonB(){}
    private static volatile SingletonB singletonB = null;
    static SingletonB getTon(){
        if (singletonB == null){
            synchronized (Singleton.class){
                if (singletonB == null){
                    singletonB = new SingletonB();
                }
            }
        }
        return singletonB;
    }
    String name;
}