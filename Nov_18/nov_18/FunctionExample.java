package com.java.training.nov_18;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        List<Employ> employList = new ArrayList<Employ>();
        employList.add(new Employ(1, "Ram", 84823.22));
        employList.add(new Employ(2, "Anitha", 90032.22));
        employList.add(new Employ(3, "Kamal", 90011.22));
        employList.add(new Employ(4, "Nalini", 99211.22));
        employList.add(new Employ(5, "Prajwal", 99011.22));
        employList.add(new Employ(6, "Nimisha", 84411.22));

        Function<Employ, String> getName = e -> e.getName();
        System.out.println("Employee names are:");
        employList.stream().map(getName).forEach(System.out::println);

        System.out.println("Increment Basic");
        Function<Employ, Double> incr = e -> e.getBasic()*1.1;
        employList.stream().map(incr).forEach(System.out::println);

        Function<Double,String> toString = s -> " Updated Salary " +s;

        System.out.println("Multiple Employee Records are   ");

        employList.stream().map(incr.andThen(toString)).forEach(System.out::println);

        Function<Employ, Employ> increment = e ->
                new Employ(e.getEmpno(), e.getName(), e.getBasic() * 1.10);
        System.out.println("Employee Records are after returning  ");
        employList.stream().map(increment).forEach(System.out::println);
    }
}
