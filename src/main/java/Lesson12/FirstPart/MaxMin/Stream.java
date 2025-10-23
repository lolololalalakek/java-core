package Lesson12.FirstPart.MaxMin;

import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);

        nums.stream()
            .mapToInt(n -> n)
            .max()
            .ifPresent(max -> System.out.println("Maximum: " + max));

        // выводим минимум
        nums.stream()
            .mapToInt(n -> n)
            .min()
            .ifPresent(min -> System.out.println("Minimum: " + min));

    }
}
