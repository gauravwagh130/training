package com.java.training.nov_19;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorEx {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(()->{
            System.out.println("Task Executed using Executor");
        });

    }
}
