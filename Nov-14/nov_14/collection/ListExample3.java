package com.java.training.nov_14.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExample3 {
    public static void main(String[] args) {
    List employs = new ArrayList();
    employs.add(new Employ(1, "Gaurav", 98457));
    employs.add(new Employ(2, "Nikhil", 88457));
    employs.add(new Employ(3, "Saurav", 55457));


    for (Object ob : employs){
        Employ employ = (Employ) ob;
        System.out.println(ob);
    }
    }
}
