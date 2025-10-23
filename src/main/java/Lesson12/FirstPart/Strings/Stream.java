package Lesson12.FirstPart.Strings;

import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        words.stream()
            .filter(element -> element.length() > 5)
            .forEach(System.out::println);
    }
}
