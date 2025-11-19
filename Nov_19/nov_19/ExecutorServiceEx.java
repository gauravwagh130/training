package com.java.training.nov_19;

import java.util.concurrent.*;

public class ExecutorServiceEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService service = Executors.newFixedThreadPool(2);
//
//        Callable<Integer> task = () -> 10 * 5;
//
//        Future<Integer> result = service.submit(task);
//        System.out.println("Result: " + result.get());
//
//        service.shutdown();
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int num = i;
            service.submit(() -> {
                System.out.println("Task " + num + " executed by " + Thread.currentThread().getName());
            });
        }

        service.shutdown();


    }
}
