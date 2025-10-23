package Lesson12.FirstPart.Grouping;

import java.util.List;

public class For {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");

        System.out.println("These names starts with A: ");
        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }

        System.out.println("These names starts with B: ");
        for (String name : names) {
            if (name.startsWith("B")) {
                System.out.println(name);
            }
        }

        System.out.println("These names starts with C: ");
        for (String name : names) {
            if (name.startsWith("C")) {
                System.out.println(name);
            }
        }


    }
}
