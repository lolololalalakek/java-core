package Lesson12.FirstPart.AverageLength;

import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        double result = names.stream()
            .mapToInt(element -> element.length())
            .average()
            .getAsDouble();

        System.out.println("Average length of strings is " + result);
    }
}
