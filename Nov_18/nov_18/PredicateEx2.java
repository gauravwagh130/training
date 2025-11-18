package com.java.training.nov_18;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx2 {
    public static void main(String[] args) {
        List<Employ> employList = new ArrayList<Employ>();
        employList.add(new Employ(1, "Raj", 84823.22));
        employList.add(new Employ(2, "Anitha", 90032.22));
        employList.add(new Employ(3, "Kamal", 90011.22));
        employList.add(new Employ(4, "Nalini", 99211.22));
        employList.add(new Employ(5, "Prajwal", 99011.22));
        employList.add(new Employ(6, "Nimisha", 84411.22));

        System.out.println("salary between 80000 and 90000");
        Predicate<Employ> compareBasic = e -> e.getBasic() >= 80000 && e.getBasic() <= 90000;
        employList.stream().filter(compareBasic).forEach(System.out::println);

        System.out.println("Employ names are start with 'N' ");
        Predicate<Employ> part = e -> e.getName().startsWith("N");
        employList.stream().filter(part).forEach(System.out::println);

        System.out.println("Employ names are not start with 'N' ");
        employList.stream().filter(part.negate()).forEach(System.out::println);
    }
}
