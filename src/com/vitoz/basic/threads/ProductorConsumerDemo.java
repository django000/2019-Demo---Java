package com.vitoz.basic.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhengwentao on 2018/8/21.
 */
public class ProductorConsumerDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(15);

        // Show the demo with GoodsWithSyn
//        GoodsWithSyn goodsWithSyn = new GoodsWithSyn(8);
//        for(int i=0; i<5; i++){
//            service.submit(new Productor(goodsWithSyn));
//        }
//        for(int i=0; i<10; i++){
//            service.submit(new Consumer(goodsWithSyn));
//        }

        // Show the demo with GoodsWithLock
//        GoodsWithLock goodsWithLock = new GoodsWithLock(15);
//        for(int i=0; i<5; i++){
//            service.submit(new Productor(goodsWithLock));
//        }
//        for(int i=0; i<10; i++){
//            service.submit(new Consumer(goodsWithLock));
//        }

        // Show the demo with GoodsWithLBQ
        GoodsWithLBQ goodsWithLBQ = new GoodsWithLBQ(15);
        for(int i=0; i<5; i++){
            service.submit(new Productor(goodsWithLBQ));
        }
        for(int i=0; i<10; i++){
            service.submit(new Consumer(goodsWithLBQ));
        }

//        service.shutdown();
    }
}

class Productor implements Runnable{
    private GoodsWith goodsWith;

    public Productor(GoodsWith goodsWith){
        this.goodsWith = goodsWith;
    }

    @Override
    public void run() {
        goodsWith.produceGoods();
    }
}

class Consumer implements Runnable{
    private GoodsWith goodsWith;
    public Consumer(GoodsWith goodsWith){
        this.goodsWith = goodsWith;
    }

    @Override
    public void run() {
        goodsWith.consumeGoods();
    }
}



