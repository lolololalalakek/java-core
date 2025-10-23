package Lesson12.SecondPart.MethodFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    // Метод фильтрует коллекцию вручную как Stream
    List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {

        List<Integer> result = new ArrayList<>();
        for (Integer element : list) { //проходимся по списку
            if (predicate.test(element)) { //если условие удовлетворяется,
                result.add(element); // то элемент добавляется
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Test test = new Test();

        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(-24);
        integers.add(1);
        integers.add(9);
        integers.add(-6);
        integers.add(0);
        integers.add(-11);
        integers.add(1);

        System.out.println("Original list: " + integers);

        // Фильтрация положительных чисел
        List<Integer> positive = test.filter(integers, element -> element > 0);

        System.out.println("After filtration: " + positive);


    }
}
