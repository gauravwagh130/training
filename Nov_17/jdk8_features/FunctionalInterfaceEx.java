package com.java.training.nov_17.jdk8_features;
@FunctionalInterface
interface Add{
    int sum(int x, int y);
}

public class FunctionalInterfaceEx {
    public static void main(String[] args) {
        Add ob = (x, y) -> x + y;
        System.out.println("sum is " + ob.sum(10,22));
    }

}
