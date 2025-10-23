package Lesson12.SecondPart.TwoFunctions;

import java.util.function.Function;

public class Test {
    public static void main(String[] args) {

        Function<String, String> trim = element -> element.trim();
        Function<String, String> toUpperCase = element -> element.toUpperCase();

        // Объединяем сразу при вызове, без третьей переменной
        System.out.println(trim.andThen(toUpperCase).apply("     hello world    "));
        System.out.println(trim.andThen(toUpperCase).apply("   java   "));
        System.out.println(trim.andThen(toUpperCase).apply("   eminem  "));
    }
}
