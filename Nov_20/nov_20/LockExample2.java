package com.java.training.nov_20;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample2 {
    public static int count = 0;
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Lock lock = new ReentrantLock();

        Callable<Integer> incrementCount = ()->{
            lock.lock();
            try{
                int newValue = count ++;
                System.out.println(Thread.currentThread().getName() + " : " + newValue);
                return newValue;
            } finally {
                lock.unlock();
            }

        };

    }

}
