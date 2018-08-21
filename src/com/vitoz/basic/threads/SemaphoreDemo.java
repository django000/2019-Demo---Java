package com.vitoz.basic.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhengwentao on 2018/8/21.
 */
public class SemaphoreDemo {
    private static Semaphore semaphore = new Semaphore(6);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        System.out.println("开始时许可证有"+semaphore.availablePermits()+"个");
        for (int i=0; i<4; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+" 同学准备获取笔......");
                        // 每个线程获取两个许可证，然而只释放了一个
                        semaphore.acquire(2);
                        System.out.println(Thread.currentThread().getName()+" 同学准备到笔......");
                        System.out.println(Thread.currentThread().getName()+" 同学填写表格......");
                        TimeUnit.SECONDS.sleep(2);
                        semaphore.release(1);
                        System.out.println(Thread.currentThread().getName()+" 同学归还借到的笔......");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            });
        }
        executorService.shutdown();
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("结束时许可证有"+semaphore.availablePermits()+"个");

    }

}
