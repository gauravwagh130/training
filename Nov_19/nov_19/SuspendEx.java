package com.java.training.nov_19;
class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("i value: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class SuspendEx {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new MyThread();
        Thread t1 = new Thread(r);
        t1.start();
        Thread.sleep(2000);
    }
}
