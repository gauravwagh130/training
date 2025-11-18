package com.java.training.nov_14.collection;

import java.util.Vector;

public class VectorEx {

    public static void main(String[] args) {
        Vector vector = new Vector(3,2);
        System.out.println("Size " + vector.size());
        System.out.println("Capacity : " + vector.capacity());

        vector.addElement("Om");
        vector.addElement("Gaurav");
        System.out.println("Size " + vector.size());
        System.out.println("Capacity : " + vector.capacity());

        vector.addElement("Nikhil");
        System.out.println("Size " + vector.size());
        System.out.println("Capacity : " + vector.capacity());

        vector.addElement("Kishor");
        System.out.println("Size " + vector.size());
        System.out.println("Capacity : " + vector.capacity());
    }
}