package ru.sbt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.function.Function;

public class Functions {
    public static void run(Function<String, Integer> hashCodeF) {
        Integer hashCode = hashCodeF.apply("Alex");
    }

    public static void main(String[] args) {
        run(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.hashCode();
            }
        });


        run(s -> Integer.parseInt(s));
        run(s -> s.hashCode());


        Function<String, Integer> parseInt = Integer::parseInt;
        run(parseInt);

        Function<String, Integer> hashCode = String::hashCode;
        run(hashCode);


        run(s -> 10);
        run(s -> null);

        run(s -> {
            try {
                 new FileOutputStream(s);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });
    }
}
