package ru.sbt;

import java.util.List;
import java.util.Map;

// fs is present
// group student by FS
// most favoriteSubject
// average mark of each subject

class Class {
    List<Student> students;
}

public class Student {
    private String favoriteSubject;
    private Map<String, Integer> marks;
}
