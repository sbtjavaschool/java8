package ru.sbt;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Streams {
    public List<String> filterName(List<Person> persons) {
        List<String> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().equals("Alex") && person.getAge() > 18) {
                result.add(person.getLastName());
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<String> filterNameJ8(List<Person> persons) {
        Stream<String> stream = persons.stream()
                .filter(p -> p.getName().equals("Alex"))
                .map(Person::getLastName)
                .filter(s -> s.length() > 18)
                .sorted(); /*lazy*/

        return stream.collect(toList());
    }

    public Set<Child> doRun(List<Person> persons) {
        Stream<List<Child>> parent = persons.stream()
                .filter(p -> p.getName().equals("Parent"))
                .map(p -> p.getChildren())
                .filter(l -> l.size() > 18);

        Optional<Child> child = persons.stream()
                .filter(p -> p.getName().equals("Parent"))
                .flatMap(p -> p.getChildren().stream())
                .filter(c -> c.getAge() > 18)
                .findAny();
        Child child1 = child.orElse(new Child());

        for (Person person : persons) {
            System.out.println(person);
        }

        persons.forEach(person -> System.out.println(person));
        persons.forEach(System.out::println);

        Map<Person, Integer> collect = persons.stream()
                .filter(p -> p.getChildren().size() > 2)
                .collect(toMap(p -> p, p -> p.getChildren().size()));

        Map<String, List<Child>> m2 = persons.stream()
                .collect(toMap(Person::getLastName, Person::getChildren));

        Map<String, List<Person>> personsByLastName =
                persons.stream().collect(groupingBy(Person::getLastName));

        Map<String, Double> collect1 = persons.stream()
                .collect(groupingBy(Person::getLastName, averagingInt(Person::getAge)));

        int[] ints = IntStream.of(1, 243, 423, 423, 423)
                .filter(n -> n > 23)
                .map(i -> i + 10)
                .distinct()
                .toArray();
        return null;
    }
}
