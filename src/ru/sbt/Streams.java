package ru.sbt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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

    public static List<String> filterNameJ8(List<Person> persons, Function<List<Person>, Stream<String>> f) {
        return f.apply(persons).collect(toList());
    }

    public static void main(String[] args) {
        filterNameJ8(new ArrayList<>(), Streams::getStream);
    }

    private static Stream<String> getStream(List<Person> persons) {
        return persons.stream()
                    .filter(p -> p.getName().equals("Alex"))
                    .map(Person::getLastName)
                    .filter(s -> s.length() > 18)
                    .sorted();
    }
}
