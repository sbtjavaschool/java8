package ru.sbt;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.valueOf;
import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "10", "2");
        sort(strings, (s1, s2) -> valueOf(s1).compareTo(valueOf(s2)));



        System.out.println(strings);
    }
}