package Lesson12.SecondPart.ReturnStringsLength;

import java.util.function.Function;

public class Test {
    public static void main(String[] args) {

        Function<String, Integer> length = element -> element.length();

        System.out.println(length.apply("Rambo"));
        System.out.println(length.apply("Eminem"));
        System.out.println(length.apply("Axe"));
    }
}
