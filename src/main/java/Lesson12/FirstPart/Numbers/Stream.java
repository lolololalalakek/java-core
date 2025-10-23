package Lesson12.FirstPart.Numbers;

import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().
            filter(element -> element % 2 == 0).
            map(element -> element * element).
            forEach(System.out::println);
    }
}
