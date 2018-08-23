package com.vitoz.basic.collection;


public class CollectionDemo {
    public static void main(String[] args) throws InterruptedException{
        LinkedToBlockingHeap<String> linked = new LinkedToBlockingHeap<>();
        ProducerHeap producerHeap = new ProducerHeap(linked);
        ConsumerHeap consumerHeap = new ConsumerHeap(linked);

        new Thread(producerHeap).start();
        new Thread(producerHeap).start();
        new Thread(producerHeap).start();
        new Thread(consumerHeap).start();
        new Thread(consumerHeap).start();
        new Thread(consumerHeap).start();

    }

}
class ProducerHeap implements Runnable{
    private LinkedToBlockingHeap linked;
    ProducerHeap(LinkedToBlockingHeap linked){
        this.linked = linked;
    }
    @Override
    public void run(){
        while (true){
            try {
                linked.addElement();
            }catch (Exception e){

            }
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
        while (true){
            try {
                linked.removeElement();
            }catch (Exception e){

            }
        }

    }
}
