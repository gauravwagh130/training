package com.java.training.nov_19;

public class ThreadEx extends Thread {
    public void run(){
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        ThreadEx t = new ThreadEx();
        t.start();
    }
}
