package com.java.training.nov_13;

public class StaticEx {
    static int count;
    static {
        System.out.println("this is static block");
    }
    static {
        System.out.println("this is second static block");
    }
    public void increment(){
        count++;

    }

    public static void main(String[] args) {
        StaticEx obj = new StaticEx();
        StaticEx obj1 = new StaticEx();
        StaticEx obj2 = new StaticEx();
        obj.increment();
        obj1.increment();
        obj2.increment();
        System.out.println(count);
    }
}
