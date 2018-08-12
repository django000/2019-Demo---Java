package com.vitoz.bxd;

public class ThreadTest extends Thread {
    @Override
    public void run(){
        for (int i=0;i<10;i++){
            System.out.print(i+"\t");
        }
    }

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        tt.run();
    }
}
