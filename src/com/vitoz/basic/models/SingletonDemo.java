package com.vitoz.basic.models;

import java.util.concurrent.atomic.AtomicReference;

public class SingletonDemo {
    public static void main(String[] args) {
        SingletonA singletonA = SingletonA.getTon();
        SingletonB singletonB = SingletonB.getTon();
        SingletonC singletonC = SingletonC.getTon();
        SingletonD singletonD = SingletonD.getTon();
        SingletonE singletonE = SingletonE.INSTANCE;
        SingletonF singletonF = SingletonF.getTon();
    }
}

// 1.饿汉式
class SingletonA{
    private SingletonA(){}
    private static final SingletonA singletonA = new SingletonA();
    public static SingletonA getTon(){
        return singletonA;
    }
}

// 2.懒汉式双重校验锁
class SingletonB{
    private SingletonB(){}
    private static volatile SingletonB singletonB = null;
    static SingletonB getTon(){
        if (singletonB == null){
            synchronized (SingletonB.class){
                if (singletonB == null){
                    singletonB = new SingletonB();
                }
            }
        }
        return singletonB;
    }
}

// 3.饿汉式变种（静态代码块）
class SingletonC{
    private SingletonC(){};
    private static SingletonC instance = null;
    static {
        instance = new SingletonC();
    }
    public static SingletonC getTon(){
        return instance;
    }
}

// 4.静态内部类
class SingletonD{
    private SingletonD(){};
    private static class SingletonHolder{
        private static final SingletonD INSTANCE = new SingletonD();
    }
    public static SingletonD getTon(){
        return SingletonHolder.INSTANCE;
    }
}

// 5.枚举
enum SingletonE{
    INSTANCE;
}

// 6. 使用乐观锁CAS实现单例
class SingletonF{
    private SingletonF(){};
    private static final AtomicReference<SingletonF> INSTANCE = new AtomicReference<SingletonF>();

    public static SingletonF getTon(){
        while (true){
            SingletonF singleton = INSTANCE.get();
            if (singleton != null){
                return singleton;
            }else{
                singleton = new SingletonF();
                if (INSTANCE.compareAndSet(null, singleton)){
                    return singleton;
                }
            }
        }
    }
}