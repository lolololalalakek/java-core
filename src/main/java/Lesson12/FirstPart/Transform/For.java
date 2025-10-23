package Lesson12.FirstPart.Transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class For {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "kiwi");

        Map<String, Integer> fruitsMap = new HashMap<>(); //создаю хеш-мапу, в которую буду все ложить

        for (String fruit : fruits) {
            fruitsMap.put(fruit, fruit.length()); //здесь непосредственно ложу
        }

        System.out.println(fruitsMap);

    }
}
