package com.vitoz.basic.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLockBody deadLockBodyA = new DeadLockBody(true);
        DeadLockBody deadLockBodyB = new DeadLockBody(false);
        new Thread(deadLockBodyA).start();
        new Thread(deadLockBodyB).start();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

    }
}

class DeadLockBody implements Runnable{
    private Boolean flag;
    DeadLockBody(Boolean flag){
        this.flag = flag;
    }
    @Override
    public void run(){
        if (flag){
            synchronized (Lockbody.lockA){
                System.out.println("if lockA");
                synchronized (Lockbody.lockB){
                    System.out.println("if lockB");
                }
            }
        }else{
            synchronized (Lockbody.lockB){
                System.out.println("else lockB");
                synchronized (Lockbody.lockA){
                    System.out.println("else lockA");
                }
            }
        }
    }
}

class Lockbody{
    static Object lockA = new Object();
    static Object lockB = new Object();
}