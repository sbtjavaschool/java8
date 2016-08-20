package ru.sbt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PersonFilters {
   /* public List<Person> filterName(List<Person> persons) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().equals("Alex")) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> filterByAge(List<Person> persons) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() >= 18) {
                result.add(person);
            }
        }
        return result;
    }*/

    public static List<Person> filterByAge(List<Person> persons, Predicate<Person> predicate) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        List<Person> result = filterByAge(persons, new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() >= 18;
            }
        });
        List<Person> result2 = filterByAge(persons, new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getName().equals("Alex");
            }
        });

        List<Person> result3 = filterByAge(persons, p -> p.getAge() >= 18);
        List<Person> result4 = filterByAge(persons, p -> p.getName().equals("Alex"));
        List<Person> result5 = filterByAge(persons, p -> p.getName().equals("Alex") && p.getAge() > 18);
    }

    public static void j8() {
        List<Person> persons = new ArrayList<>();
        Function<Integer, Predicate<Person>> olderThan = age -> p -> p.getAge() >= age;
        Function<String, Predicate<Person>> withName = name -> p -> p.getName().equals(name);

        List<Person> result3 = filterByAge(persons, olderThan.apply(18));
        List<Person> result4 = filterByAge(persons, withName.apply("Alex"));
        List<Person> result5 = filterByAge(persons, withName.apply("Bob").or(olderThan.apply(25)));
    }
}
