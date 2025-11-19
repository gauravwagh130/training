package com.java.training.nov_19;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Service3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.submit(()->{
            System.out.println("Welcome to Service3");
        });
        Future<List<String>> names = service.submit(()->{
            System.out.println("List of Names are getting returned...");
            List<String> students = Arrays.asList("Gaurav","Anusri","Karthik","Sujit","Indu");
            return students;
        });

        names.get().forEach(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();
        System.out.println("Program Completed...");

        
    }
}
