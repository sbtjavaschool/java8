package ru.sbt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

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

    public List<Student> getStudents() {
        return students;
    }
}

class Student {
    private String favoriteSubject;
    private Map<String, Integer> marks;

    public String getFavoriteSubject() {
        return favoriteSubject;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }
}

class Task {
    public static void main(String[] args) {
        List<Class> aClass = new ArrayList<>();
        //1
        List<Student> studentWithFavoriteSubject = aClass.stream()
                .flatMap(c -> c.getStudents().stream())
                .filter(student -> student.getFavoriteSubject() != null)
                .collect(toList());

        //2
        Map<String, List<Student>> studentBySubject = aClass.stream()
                .flatMap(c -> c.getStudents().stream())
                .collect(groupingBy(Student::getFavoriteSubject));

        //3
        Map<String, Long> subjectToCount = aClass.stream()
                .flatMap(c -> c.getStudents().stream())
                .collect(groupingBy(Student::getFavoriteSubject, counting()));

        String subject = subjectToCount.entrySet()
                .stream()
                .max(comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse(null);

        //4
        Map<String, Double> subjectToAverageMark = aClass.stream()
                .flatMap(c -> c.getStudents().stream())
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey, averagingInt(Map.Entry::getValue)));
    }
}

