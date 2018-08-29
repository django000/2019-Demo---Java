package com.vitoz.offer;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhengwentao on 2018/8/29.
 */
public class Demo9_2 {
    public static void main(String[] args) {
        QueueToStack<Integer> stack = new QueueToStack<>(3);
        stack.appendTail(2);
        System.out.println(stack.deleteTail());
        stack.appendTail(3);
        stack.appendTail(4);
        stack.appendTail(5);
        stack.appendTail(6);
        System.out.println(stack.deleteTail());
        System.out.println(stack.deleteTail());
        System.out.println(stack.deleteTail());
        System.out.println(stack.deleteTail());
    }
}

class QueueToStack<T> {
    private int flag;
    private Queue<T>[] queues = new Queue[2];
    QueueToStack(int value){
        queues[0] = new ArrayBlockingQueue<T>(value);
        queues[1] = new ArrayBlockingQueue<T>(value);
    }

    public void appendTail(T element){
        queues[flag].offer(element);
    }

    public T deleteTail(){
        if (queues[flag].isEmpty()){
            throw new NoSuchElementException("Queue is empty. ");
        }
        while (queues[flag].size() > 1){
            queues[flag^1].offer(queues[flag].poll());
        }
        flag = flag^1;
        return queues[flag^1].poll();
    }
}
