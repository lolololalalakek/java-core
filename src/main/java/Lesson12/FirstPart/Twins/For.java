package Lesson12.FirstPart.Twins;

import java.util.ArrayList;
import java.util.List;

public class For {
    public static void main(String[] args) {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");

        List<String> result = new ArrayList<>();

        for (String word : input) {
            if (!result.contains(word)) {
                result.add(word);
            }
        }


        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = 0; j < result.size(); j++) {
                if (result.get(i).length() > result.get(j).length()) {
                    String temp = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, temp);
                }
            }
        }


        System.out.println(result);


    }
}
