package Lesson12.FirstPart.Twins;

import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        List<String> result = input.stream()
            .distinct()                             // метод, который убирает дубликаты
            .sorted((a, b) -> a.length() - b.length()) // метод сортировки
            .toList();

        System.out.println("Before: " + input);
        System.out.println("After: " + result);


    }
}
