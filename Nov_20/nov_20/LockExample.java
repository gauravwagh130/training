package com.java.training.nov_20;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Task{
    private static final Lock lock = new ReentrantLock();
    void printNumbers(){
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        } finally {
                lock.unlock();
            }
        }
    }

public class LockExample {


    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(task::printNumbers);
        Thread t2 = new Thread(task::printNumbers);
        t1.start();
        t2.start();

    }
}
