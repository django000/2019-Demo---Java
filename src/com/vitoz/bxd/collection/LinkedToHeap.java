package com.vitoz.bxd.collection;

import java.util.*;

public class LinkedToHeap<E> {
    private LinkedList<E> linked = new LinkedList<E>();

    public Boolean addElement(E e){
        return linked.offerLast(e);
    }
    public E removeElement(){
        return linked.pollLast();
    }

    public Boolean isEmpty(){
        return linked.isEmpty();
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
    public static void main(String[] args) {
        LinkedToHeap<String> linkedToHeap = new LinkedToHeap<String>();
        linkedToHeap.addElement("1");
        linkedToHeap.addElement("2");
        linkedToHeap.addElement("3");
        System.out.println(linkedToHeap);
        System.out.println(linkedToHeap.removeElement());
        System.out.println(linkedToHeap.removeElement());
        System.out.println(linkedToHeap.removeElement());
    }

}
