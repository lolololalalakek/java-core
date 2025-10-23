package Lesson12.FirstPart.AverageLength;

import java.util.List;

public class For {
    public static void main(String[] args) {

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        int result = 0;
        for (String name : names) {
            result += name.length();
        }
        double avgLength = result / names.size();


        System.out.println("Average length of strings is " + avgLength);
    }
}
