package com.vitoz.basic.collection;

public class CollectionTest {
    public static void main(String[] args) throws InterruptedException{
        LinkedToBlockingHeap<String> linked = new LinkedToBlockingHeap<>(2);
        ProducerHeap producerHeap = new ProducerHeap(linked);
        ConsumerHeap consumerHeap = new ConsumerHeap(linked);

        new Thread(producerHeap).start();
//        new Thread(producerHeap).start();
//        new Thread(producerHeap).start();
        new Thread(consumerHeap).start();
//        new Thread(consumerHeap).start();
//        new Thread(consumerHeap).start();
    }

}
class ProducerHeap implements Runnable{
    private LinkedToBlockingHeap linked;
    ProducerHeap(LinkedToBlockingHeap linked){
        this.linked = linked;
    }
    @Override
    public void run(){
        try {
            linked.addElement("input");
        }catch (Exception e){

        }
    }
}

class ConsumerHeap implements Runnable{
    private LinkedToBlockingHeap linked;
    ConsumerHeap(LinkedToBlockingHeap linked){
        this.linked = linked;
    }
    @Override
    public void run(){
        try {
            System.out.println(linked.removeElement());
        }catch (Exception e){

        }
    }
}
