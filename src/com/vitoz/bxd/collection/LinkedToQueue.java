package com.vitoz.bxd.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedToQueue<E> {
    private LinkedList<E> linked = new LinkedList<E>();

    public Boolean addElement(E e){
        return linked.offerLast(e);
    }

    public E removeElement(){
        return linked.pollFirst();
    }

    public Boolean isEmpty(){
        return linked.isEmpty();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        for (Iterator<E> iterator = linked.iterator(); iterator.hasNext();){
            sb.append(iterator.next().toString()+" ");
        }
        int len = sb.length();
        sb.delete(len-1, len);
        sb.append("]");
        return sb.toString();
    }

}
