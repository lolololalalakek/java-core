package Lesson12.SecondPart.BiFunctionMultiply;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {

        // Используй andThen(), чтобы объединить в одну цепочку.
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        System.out.println(multiply.andThen(toStr).apply(5, 10));

    }
}
