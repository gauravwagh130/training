package com.java.training.nov_19;

class Bank{
    int balance = 1000;
    synchronized void deposit(int amount){
        balance = balance + amount;
        System.out.println("Balance :"+ balance);
    }
}
class Counter{
    int count = 0;
    void increment(){
        synchronized (this){
            count++;
            System.out.println("Count:" + count);
        }
    }
}

public class SynchronizationEx {
    public static void main(String[] args) {
        Bank b = new Bank();

        Thread th1 = new Thread(()-> b.deposit(500));
        Thread th2 = new Thread(()-> b.deposit(1000));

        th1.start();
        th2.start();

        Counter c = new Counter();
        Thread th3 = new Thread(()-> c.increment());
        Thread th4 = new Thread(()-> c.increment());
        th3.start();
        th4.start();
    }
}
