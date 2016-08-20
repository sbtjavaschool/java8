package ru.sbt;

import java.util.List;
import java.util.Map;

// fs is present
// group student by FS

// most favoriteSubject
// 1) map student->subject
// 2) group by subjectName
// 3) find entry with max value
// 4) entry::getKey


// average mark of each subject

class Class {
    List<Student> students;
}

public class Student {
    private String favoriteSubject;
    private Map<String, Integer> marks;
}
