package com.java.training.nov_14.collection;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {
        LinkedList names = new LinkedList();
        names.add("Sham");
        names.add("Ram");
        names.addFirst("Gaurav");
        names.addLast("Nikhil");

        System.out.println("Names are using LinkedList :");
        for (Object ob : names){
            System.out.println(ob);
        }
    }
}
