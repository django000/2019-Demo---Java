package com.vitoz.basic.thread;

import java.util.concurrent.*;

/**
 * Created by zhengwentao on 2018/8/21.
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<Integer> future1 = service.submit(new Runnable() {
            @Override
            public void run() {

            }
        }, 4);
        Future<Integer> future2 = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 4;
            }
        });

        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(new Runnable() {
            @Override
            public void run() {

            }
        }, 4);
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 4;
            }
        });
        service.submit(futureTask1);
        service.submit(futureTask2);
        service.shutdown();

        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if (future1.isDone()){
                System.out.println(future1.get());
            }
            if (future2.isDone()){
                System.out.println(future2.get());
            }
            if (futureTask1.isDone()){
                System.out.println(futureTask1.get());
            }
            if (futureTask2.isDone()){
                System.out.println(futureTask2.get());
            }
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
