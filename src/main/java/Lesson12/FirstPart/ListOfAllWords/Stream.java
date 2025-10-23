package Lesson12.FirstPart.ListOfAllWords;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> sentences = List.of("Java is cool", "Streams are powerful");

        List<String> allWords = sentences.stream()
            .flatMap(sentence -> Arrays.stream(sentence.split(" "))) // разбиваем каждое предложение на слова
            .collect(Collectors.toList()); // собираем все слова в один список

        System.out.println(allWords);
    }
}
