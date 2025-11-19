package com.java.training.nov_19;

import java.util.*;

class First implements Runnable {

    @Override
    public void run() {
        List<String> names = new ArrayList<>();
        names.add("Gaurav");
        names.add("Ram");
        names.add("Nikhil");
        names.add("Sujit");
        names.add("Mayur");

        names.forEach(x->{
            System.out.println("Array List :" + x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

class Second implements Runnable{

    @Override
    public void run() {
        Set<String> names = new HashSet<>();
        names.add("Gaurav");
        names.add("Ram");
        names.add("Nikhil");
        names.add("Sujit");
        names.add("Mayur");
        names.add("Gaurav");
        names.add("Ram");
        names.add("Nikhil");
        names.add("Sujit");
        names.add("Mayur");

        names.forEach(x -> {
            System.out.println("HashSet Data:" + x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}

class Third implements  Runnable{

    @Override
    public void run() {
        Vector<String> names = new Vector<>();
        names.addElement("Karthik");
        names.addElement("Subham");
        names.addElement("Chandra");
        names.addElement("Indu");
        names.addElement("Priya");
        names.addElement("Shaili");

        names.forEach(x -> {
            System.out.println("Vector Data  " +x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}


public class ThreadEx4 {
    public static void main(String[] args) {
        First f = new First();
        Second s = new Second();
        Third t = new Third();

        Thread th1 = new Thread(f);
        Thread th2 = new Thread(s);
        Thread th3 = new Thread(t);

        th1.start();
        th2.start();

        try {
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        th3.start();
    }
}
