package com.vitoz.basic.thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GoodsWithLock implements GoodsWith {
    private int maxLength;
    private Lock lock = new ReentrantLock();
    private Condition conditionPro;
    private Condition conditionCon;
    private LinkedList<Goods> list = new LinkedList<>();
    public GoodsWithLock(int maxLength){
        this.maxLength = maxLength;
        this.conditionPro = lock.newCondition();
        this.conditionCon = lock.newCondition();
    }

    @Override
    public void produceGoods(){
        while (true){
            lock.lock();
            try{
                while (list.size() == this.maxLength){
                    System.out.println("生产者" + Thread.currentThread().getName() + "  list以达到最大容量，进行wait");
                    conditionPro.await();
                    System.out.println("生产者" + Thread.currentThread().getName() + "  退出wait");
                }
                Goods goods = new Goods();
                list.addLast(goods);
                System.out.println("生产者" + Thread.currentThread().getName() + " 生产商品 "+goods);
                conditionCon.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void consumeGoods(){
        while (true){
            lock.lock();
            try {
                while (list.isEmpty()){
                    System.out.println("消费者" + Thread.currentThread().getName() + "  list为空，进行wait");
                    conditionCon.await();
                    System.out.println("消费者" + Thread.currentThread().getName() + "  退出wait");
                }
                Goods goods = list.removeFirst();
                System.out.println("消费者" + Thread.currentThread().getName()+"消费商品 "+goods);
                conditionPro.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
