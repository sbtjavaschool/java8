package ru.sbt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public List<String> filterNameJ8(List<Person> persons) {
        Stream<String> stream = persons.stream()
                .filter(p -> p.getName().equals("Alex"))
                .map(Person::getLastName)
                .filter(s -> s.length() > 18)
                .sorted(); /*lazy*/

        return stream.collect(toList());
    }
}
