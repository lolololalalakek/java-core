package Lesson12.FirstPart.Transform;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "kiwi");


        Map<String, Integer> fruitsMap = fruits.stream()
            .collect(Collectors.toMap(
                element -> element,
                element -> element.length()
            ));

        System.out.println(fruitsMap);


    }
}
