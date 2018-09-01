package com.vitoz.offer.chapter4;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 00:08
 * @Description: 剑指offer面试题30——包含min函数的栈
 */
public class Demo30 {
    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(32);
        stack.push(12);
        stack.push(23);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
//        System.out.println(stack.min());
    }
}

// 包含min函数的栈结构，其内部包括一个数据栈和一个辅助栈（后者主要用于对应存储数据插入时的全栈最小值）
class StackWithMin<E extends Integer>{
    private Stack stackD = new Stack();
    private Stack stackM = new Stack();

    public void push(E e){
        stackD.push(e);
        if (stackM.size() == 0 || (Integer)e < (Integer)stackM.peek()){
            stackM.push(e);
        }else {
            stackM.push(stackM.peek());
        }
    }

    public E pop(){
        if (stackD.isEmpty() || stackM.isEmpty()){
            throw new EmptyStackException();
        }
        stackM.pop();
        return (E)stackD.pop();
    }

    public E min(){
        if (stackD.isEmpty() || stackM.isEmpty()){
            throw new EmptyStackException();
        }
        return (E)stackM.peek();
    }

}
