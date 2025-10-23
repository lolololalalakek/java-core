package Lesson12.FirstPart.OneString;

import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> names = List.of("Tom", "Jerry", "Spike");

        String result = names.stream()
            .collect(Collectors.joining(", ")); // объединяем элементы через запятую

        System.out.println(result);
    }
}

