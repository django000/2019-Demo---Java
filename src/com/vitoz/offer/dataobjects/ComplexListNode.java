package com.vitoz.offer.dataobjects;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 10:19
 * @Description: 剑指offer面试题
 */
public class ComplexListNode {
    public int value;
    public ComplexListNode next;
    public ComplexListNode sibling;

    public ComplexListNode(int value){
        this(value, null, null);
    }

    public ComplexListNode(int value, ComplexListNode next, ComplexListNode sibling){
        this.value = value;
        this.next = next;
        this.sibling = sibling;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("{value=")
                .append(value)
                .append(", next=")
                .append(next!=null?next.value:"null")
                .append(", sibling=")
                .append(sibling!=null?sibling.value:"null")
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
