package com.vitoz.basic.thread;

import java.util.concurrent.LinkedBlockingQueue;

public class GoodsWithLBQ implements GoodsWith {
    private LinkedBlockingQueue<Goods> linkedBlockingQueue;

    public GoodsWithLBQ(int maxLength){
        this.linkedBlockingQueue = new LinkedBlockingQueue<>(maxLength);
    }

    @Override
    public void produceGoods() {
        while (true){
            Goods goods = new Goods();
            try{
                linkedBlockingQueue.put(goods);
                System.out.println("生产者" + Thread.currentThread().getName() + " 生产商品 "+goods);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void consumeGoods() {
        while (true){
            try {
                Goods goods = (Goods)linkedBlockingQueue.take();
                System.out.println("消费者" + Thread.currentThread().getName()+"消费商品 "+goods);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
