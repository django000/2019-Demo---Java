package com.vitoz.basic.thread;


public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLock deadLockA = new DeadLock(true);
        DeadLock deadLockB = new DeadLock(false);
        new Thread(deadLockA).start();
        new Thread(deadLockB).start();

    }
}

class DeadLock implements Runnable{
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();
    private Boolean flag;
    DeadLock(Boolean flag){
        this.flag = flag;
    }
    @Override
    public void run(){
        if (flag){
            synchronized (lockA){
                System.out.println("if lockA");
                synchronized (lockB){
                    System.out.println("if lockB");
                }
            }
        }else{
            synchronized (lockB){
                System.out.println("else lockB");
                synchronized (lockA){
                    System.out.println("else lockA");
                }
            }
        }
    }
}
