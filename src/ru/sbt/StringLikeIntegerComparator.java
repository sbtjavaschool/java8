package ru.sbt;

import java.util.Comparator;

public class StringLikeIntegerComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
    }
}
