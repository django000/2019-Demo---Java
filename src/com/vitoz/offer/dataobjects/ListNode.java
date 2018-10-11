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

    public static void printListNode(ListNode node){
        if (node != null){
            System.out.print(node.value+" -> ");
            printListNode(node.next);
        }else {
            System.out.println();
        }
    }
}
