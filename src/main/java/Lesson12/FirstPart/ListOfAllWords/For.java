package Lesson12.FirstPart.ListOfAllWords;

import java.util.ArrayList;
import java.util.List;

public class For {
    public static void main(String[] args) {
        List<String> sentences = List.of("Java is cool", "Streams are powerful");
        List<String> allWords = new ArrayList<>();

        for (String sentence : sentences) {
            String[] words = sentence.split(" "); // разбиваем предложение на слова
            for (String word : words) {
                allWords.add(word);
            }
        }

        System.out.println(allWords);
    }
}

