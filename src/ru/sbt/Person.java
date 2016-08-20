package ru.sbt;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String lastName;
    private int age;
    List<Child> children = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<Child> getChildren() {
        return children;
    }
}
