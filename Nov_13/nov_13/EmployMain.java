package com.java.training.nov_13;

public class EmployMain {
    public static void main(String[] args) {
        Employ [] arr = new Employ[]{
                new Emp1(1, "Gaurav", 876587),
                new Emp1(2, "Ram", 976587),
                new Emp1(3, "Saurav", 76587)
        };

        for(Employ emp : arr){
            System.out.println(emp);
        }
    }
}
