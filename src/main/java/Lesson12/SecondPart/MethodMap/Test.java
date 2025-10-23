package Lesson12.SecondPart.MethodMap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Test {

    // Метод вручную преобразует строки в числа (длины строк)
    List<Integer> map(List<String> list, Function<String, Integer> mapper) {
        List<Integer> result = new ArrayList<>();

        for (String element : list) {
            result.add(mapper.apply(element));
        }

        return result;
    }

    public static void main(String[] args) {

        Test test = new Test();

        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Eminem");
        strings.add("Durka");
        strings.add("Chas nochi");

        // Преобразуем строки в их длины
        List<Integer> lengths = test.map(strings, s -> s.length());

        System.out.println(lengths);
    }
}
