package Lesson12.FirstPart.Grouping;

import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");

        System.out.println("Names starts with A: ");
        names.stream()
            .filter(element -> element.startsWith("A"))
            .forEach(System.out::println);

        System.out.println("Names starts with B: ");
        names.stream()
            .filter(element -> element.startsWith("B"))
            .forEach(System.out::println);

        System.out.println("Names starts with C: ");
        names.stream()
            .filter(element -> element.startsWith("C"))
            .forEach(System.out::println);
    }
}
