package com.java.training.nov_14.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortEmploy {
    public static void main(String[] args) {
        Comparator comp = new NameComparator();
        SortedSet employs = new TreeSet(comp);
        employs.add(new Employ(1,"Abhay",8234));
        employs.add(new Employ(2,"Gaurav",99876));
        employs.add(new Employ(3,"Danny",67234));
        employs.add(new Employ(4,"Akshitha",78032));
        employs.add(new Employ(5,"Bharat",10322));
        employs.add(new Employ(6,"Aarti",43223));

        System.out.println("Employ Records are  ");
        for(Object ob : employs){
            Employ employ = (Employ)ob;
            System.out.println(employ);
        }
    }
}
