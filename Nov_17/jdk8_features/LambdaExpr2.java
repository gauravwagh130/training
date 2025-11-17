package com.java.training.nov_17.jdk8_features;

interface Calculation{
    int calc(int x, int y);
}
public class LambdaExpr2 {
    public static void main(String[] args) {
        Calculation ob = (x, y) -> x + y;
        System.out.println("Sum is:" + ob.calc(10,5));
    }
}
