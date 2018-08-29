package com.vitoz.offer;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by zhengwentao on 2018/8/29.
 */
public class Demo9_1 {
    public static void main(String[] args) {
        StackToQueue<String> queue = new StackToQueue<>();
        queue.appendTail("hello");
        queue.appendTail("world");
        queue.appendTail("happy");

        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}

class StackToQueue<T> {
    private Stack<T> stackIn = new Stack<T>();
    private Stack<T> stackOut = new Stack<T>();

    public void appendTail(T element){
        stackIn.push(element);
    }

    public T deleteHead(){
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        if (stackOut.isEmpty()){
            throw new NoSuchElementException("Queue is empty. ");
        }
        return stackOut.pop();
    }
}
