package com.vitoz.basic.thread;

/**
 * Created by zhengwentao on 2018/8/21.
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        final Thread thread = new Thread(){
            @Override
            public void run() {
                ThreadLocal threadLocal = new ThreadLocal();
                threadLocal.set(4);
                System.out.println(threadLocal.get());
            }
        };
        thread.start();
    }
}
