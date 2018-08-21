package com.vitoz.basic.threads;

import java.util.LinkedList;

public class GoodsWithSyn implements GoodsWith {
    private LinkedList<Goods> list = new LinkedList<>();
    private int maxLength;
    public GoodsWithSyn(int maxLength){
        this.maxLength = maxLength;
    }

    @Override
    public void produceGoods(){
        while (true){
            synchronized (this){
                while (list.size() == this.maxLength){
                    System.out.println("生产者" + Thread.currentThread().getName() + "  list以达到最大容量，进行wait");
                    try {
                        this.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("生产者" + Thread.currentThread().getName() + "  退出wait");
                }
                Goods goods = new Goods();
                list.addLast(goods);
                System.out.println("生产者" + Thread.currentThread().getName() + " 生产商品 "+goods);
                this.notifyAll();
            }
        }
    }

    @Override
    public void consumeGoods(){
        while (true){
            synchronized (this){
                while (list.isEmpty()){
                    System.out.println("消费者" + Thread.currentThread().getName() + "  list为空，进行wait");
                    try {
                        this.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("消费者" + Thread.currentThread().getName() + "  退出wait");
                }
                Goods goods = list.removeFirst();
                System.out.println("消费者" + Thread.currentThread().getName()+"消费商品 "+goods);
                this.notifyAll();
            }
        }
    }
}
