package Lesson12.FirstPart.Strings;

import java.util.List;

public class For {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        for (String word : words) {
            if (word.length()>5) {
                System.out.println(word);
            }
        }
    }
}
