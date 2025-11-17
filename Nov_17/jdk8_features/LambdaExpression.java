package com.java.training.nov_17.jdk8_features;

interface IGreeting{
    void greet();
}
public class LambdaExpression {

    public static void main(String[] args) {
    IGreeting ob = () -> System.out.println("Hello");
    IGreeting ob1 = () -> System.out.println("Good Morning");
    ob.greet();
    ob1.greet();
    }
}
