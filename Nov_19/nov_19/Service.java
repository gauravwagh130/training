package com.java.training.nov_19;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Service {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Integer> result = executorService.submit(() -> 10 * 5);
        System.out.println("Result: "+ result.get());

        executorService.shutdown();
    }
}
