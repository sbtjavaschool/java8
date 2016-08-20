package ru.sbt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i != 0) return i;

                i = o1.getLastName().compareTo(o2.getLastName());
                if (i != 0) return i;

                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        Comparator<Person> comparing = comparing(Person::getName, comparing(String::length))
                .thenComparing(Person::getLastName)
                .thenComparing(Person::getAge);

        persons.sort(comparing);
    }
}
