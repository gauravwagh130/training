package com.java.training.nov_14.collection;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
     Stack stack = new Stack();
     stack.push(10);
     stack.push(123);
     stack.push(42);
     stack.push(77);

        System.out.println("Stack Element are:");
        for(Object ob : stack){
            System.out.println(ob);
        }

        stack.pop();
        stack.pop();
        System.out.println("Stack Element are:");
        for(Object ob : stack){
            System.out.println(ob);
        }
    }

}
