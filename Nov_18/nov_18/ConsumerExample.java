package com.java.training.nov_18;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Employ> employList = new ArrayList<Employ>();
        employList.add(new Employ(1, "Om", 84823.22));
        employList.add(new Employ(2, "Anitha", 90032.22));
        employList.add(new Employ(3, "Kamal", 90011.22));
        employList.add(new Employ(4, "Nalini", 99211.22));
        employList.add(new Employ(5, "Prajwal", 99011.22));
        employList.add(new Employ(6, "Nimisha", 84411.22));

        Consumer<Employ> employrecord = e -> System.out.println(e);
        employList.forEach(employrecord);

        System.out.println("Emp names are");
        Consumer<Employ> empName = e -> System.out.println("Employ name " + e.getName());
        employList.forEach(empName);

        Consumer<Employ> increaseSalary = e -> e.setBasic(e.getBasic() * 2);
        employList.forEach(increaseSalary);
        employList.forEach(System.out::println);
        Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
        Consumer<String> c2 = s -> System.out.println(s.length());

        Consumer<String> combined = c1.andThen(c2);

        combined.accept("Gaurav");

    }
}
