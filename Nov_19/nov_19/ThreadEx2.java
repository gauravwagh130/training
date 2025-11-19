package com.java.training.nov_19;

public class ThreadEx2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        Runnable runnable = new ThreadEx2();
        Thread t = new Thread(runnable);
        t.start();
    }
}
