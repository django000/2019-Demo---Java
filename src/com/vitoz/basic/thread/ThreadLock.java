package com.vitoz.basic.thread;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 剑指offer面试题
 */
public class ThreadLock {
    public static void main(String[] args) {
        ThreadLock test = new ThreadLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                test.method2();
                test.method3();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        test.method1();
        System.out.println();
    }

    public synchronized void method1(){
        try {
            Thread.sleep(4000);
            System.out.print("call method1 ");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static synchronized void method2(){
        System.out.print("call method2 ");
    }

    public synchronized void method3(){
        System.out.print("call method3 ");
    }
}
