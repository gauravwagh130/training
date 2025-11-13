package com.java.training.nov_13.inheritance;

class first {
    public void show(){
        System.out.println("This method is from first class");
    }
}

class Second extends first{
    public void display(){
        System.out.println("Display method from second class");
    }
}
public class inh {
    public static void main(String[] args) {
        Second obj = new Second();
        obj.show();
        obj.display();

    }
}
