package com.vitoz.basic.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedToBlockingHeap<E> {
    private int length;
    private LinkedList<E> linked = new LinkedList<E>();

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    LinkedToBlockingHeap(){
        this(8);
    }
    LinkedToBlockingHeap(int length){
        this.length = length;
    }

    public void addElement() throws InterruptedException{
        lock.lock();
        try {
            while (isFull()){
                System.out.println("该阻塞队列已满，内容为: "+linked);
                notFull.await();
            }
            String item = "input"+new Random().nextInt(100);
            linked.addLast((E)item);
            System.out.println(Thread.currentThread().getName()+" 添加元素 "+item);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }
    public void removeElement() throws InterruptedException{
        lock.lock();
        try {
            while (isEmpty()){
                System.out.println("堆栈为空");
                notEmpty.await();
            }
            notFull.signal();
            System.out.println(Thread.currentThread().getName()+" 删除元素 "+linked.pollLast());
        }finally {
            lock.unlock();
        }
    }

    public Boolean isEmpty(){
        return linked.size() == 0;
    }
    public Boolean isFull(){
        return linked.size() == this.length;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        for (Iterator<E> iterator = linked.iterator();iterator.hasNext();){
            sb.append(iterator.next().toString()+" ");
        }
        int len = sb.length();
        sb.delete(len-1, len);
        sb.append("]");
        return sb.toString();
    }

}