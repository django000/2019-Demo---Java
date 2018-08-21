package com.vitoz.basic.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedToBlockingHeap<E> {
    private int length = 10;
    private LinkedList<E> linked = new LinkedList<E>();

    private final ReentrantLock putLock = new ReentrantLock();
    private final Condition notFull = putLock.newCondition();
    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();

    LinkedToBlockingHeap(){}
    LinkedToBlockingHeap(int length){
        this.length = length;
    }

    public void addElement(E e) throws InterruptedException{
        putLock.lock();
        try {
            while (isFull()){
                notFull.await();
            }
            linked.offerLast(e);
            notEmpty.signal();
        }finally {
            putLock.unlock();
        }
    }
    public E removeElement() throws InterruptedException{
        takeLock.lock();
        try {
            while (isEmpty()){
                System.out.println("empty");
                notEmpty.await();
            }
            notFull.signal();
        }finally {
            takeLock.unlock();
            return linked.pollLast();
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