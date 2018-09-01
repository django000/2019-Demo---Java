package com.vitoz.offer.dataobjects;

/**
 * Created by zhengwentao on 2018/8/31.
 */
public class ListNode{
    public int value;
    public ListNode next;
    public ListNode(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("{value=")
                .append(this.value)
                .append(", next=")
                .append(next!=null?next.value:"null")
                .append("}");
        return builder.toString();
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
