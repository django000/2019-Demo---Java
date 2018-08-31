package com.vitoz.offer;

/**
 * Created by zhengwentao on 2018/8/31.
 */
public class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){
        this.value = value;
    }

    public void printListNode(){
        System.out.print(value);
        if (next != null){
            System.out.print(" -> ");
            next.printListNode();
        }else {
            System.out.println();
        }
    }
}
