package com.java.training.nov_19;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Service2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(()->{
            System.out.println("Welcome to Thread Concurrency");
        });
        Future<Integer> future1 = service.submit(()->{
            System.out.println("Hi Its Future Task");
            return 1;
        });
        try {
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();
        service.submit(()->{
            System.out.println("Get well sooon");
        });
    }
}
