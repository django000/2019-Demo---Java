package com.vitoz.basic.threads;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhengwentao on 2018/8/21.
 */
public class ExchangerDemo {
    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String strBoy = exchanger.exchange("我也很喜欢你......");
                    System.out.println("男孩说："+strBoy);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String strGirl = exchanger.exchange("我其实暗恋你很久了......");
                    System.out.println("女孩说："+strGirl);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
    }

}
