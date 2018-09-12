package com.vitoz.offer.chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 21:19
 * @Description: 剑指offer面试题41——求数据流中的中位数
 */
public class Demo41 {
    public static void main(String[] args) {
        MyMedian median = new MyMedian();
        Random random = new Random();
        for (int i=0;i<100;i++){
            median.insert(random.nextInt(100000));
        }
        System.out.println(median.getMedian());
    }
}

class MyMedian{
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MyComparator<Integer>(true));
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator<Integer>(false));

    public void insert(Integer t){
        if ((count & 1) == 0){
            // 当前count为偶数时，插入minHeap。但是需要判断t是否小于maxHeap中的最大值（是则需要与maxHeap中最大值交换）
            if (maxHeap.size() > 0 && maxHeap.peek() > t){
                maxHeap.offer(t);
                t = maxHeap.poll();
            }
            minHeap.offer(t);
            // 当前count为奇数时，插入maxHeap。但是需要判断t是否大于minHeap中的最小值（是则需要与minHeap中最小值交换）
        }else {
            if (minHeap.size() > 0 && minHeap.peek() < t){
                minHeap.offer(t);
                t = minHeap.poll();
            }
            maxHeap.offer(t);
        }
        count++;
    }

    public double getMedian(){
        System.out.println(minHeap.peek());
        System.out.println(maxHeap.peek());
        if ((count & 1) == 1){
            return ((minHeap.peek() - maxHeap.peek())>>1)+maxHeap.peek()+0.0;
        }else {
            return minHeap.peek()+0.0;
        }
    }
}

class MyComparator<T> implements Comparator<T>{
    private boolean flag;
    MyComparator(boolean flag){
        this.flag = flag;
    }
    @Override
    public int compare(T o1, T o2) {
        if ((o1 instanceof Integer) || (o2 instanceof Integer)){
            Integer i1 =  (Integer)o1;
            Integer i2 =  (Integer)o2;
            return flag?i1.compareTo(i2):i2.compareTo(i1);
        }else if ((o1 instanceof String) || (o2 instanceof String)){
            String s1 =  (String)o1;
            String s2 =  (String)o2;
            return flag?s1.compareTo(s2):s2.compareTo(s1);
        }else {
            int tmp = o1.hashCode() - o2.hashCode();
            return flag?tmp:-tmp;
        }
    }
}
