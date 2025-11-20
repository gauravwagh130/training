package com.java.training.nov_20;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

class SBI {
    private int balance = 1000;
    private static final Lock lock = new ReentrantLock();

    public int depositAmount(int amount) {
        lock.lock();
        try {
            balance += amount;
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public String withdrawAmount(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                return "Withdrawn " + amount + " | New Balance: " + balance;
            } else {
                return "Insufficient Funds (Balance: " + balance + ")";
            }
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}

public class BankProject {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        SBI sbi = new SBI();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Amount for First Transfer: ");
        int a1 = sc.nextInt();
        System.out.print("Enter Amount for Second Transfer: ");
        int a2 = sc.nextInt();
        System.out.print("Enter Amount for Third Transfer: ");
        int a3 = sc.nextInt();
        System.out.print("Enter Amount for Fourth Transfer: ");
        int a4 = sc.nextInt();

        List<Integer> amounts = Arrays.asList(a1, a2, a3, a4);

        List<Callable<Integer>> depositTasks = amounts.stream()
                .map(amount -> (Callable<Integer>) (() -> {
                    int newBalance = sbi.depositAmount(amount);
                    System.out.println(Thread.currentThread().getName() + " deposited " + amount + " -> " + newBalance);
                    return newBalance;
                }))
                .collect(Collectors.toList());

        List<Future<Integer>> depositFutures = service.invokeAll(depositTasks);


        Callable<String> withdraw = () -> {
            String result = sbi.withdrawAmount(500);
            System.out.println(Thread.currentThread().getName() + " -> " + result);
            return result;
        };

        Future<String> withdrawFuture = service.submit(withdraw);



        System.out.println("Final Balance: " + sbi.getBalance());
        service.shutdown();

        }
    }

