    package com.java.training.nov_19;
    class  Factorial extends Thread{
        public void run(){
            int fact = 1;
            for (int i = 1; i <=10; i++) {
                fact = fact * i;
                System.out.println("Factorial Value:" + fact);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class Odd extends Thread {
        public void run(){
            for (int i = 1; i <= 20; i += 2) {
                System.out.println("Odd num is:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    class Even extends Thread{

        @Override
        public void run() {
            for (int i = 0; i <= 30 ; i++) {
                System.out.println("Even num is:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
    public class ThreadEx3 {
        public static void main(String[] args) {
            Factorial fact = new Factorial();
            Odd odd = new Odd();
            Even even = new Even();

            fact.setPriority(10);
            odd.setPriority(1);

            fact.start();
            odd.start();
            even.start();
        }
    }
