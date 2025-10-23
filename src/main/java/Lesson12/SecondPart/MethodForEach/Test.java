package Lesson12.SecondPart.MethodForEach;

import java.util.List;
import java.util.function.Consumer;

public class Test {

    // метод, который вручную проходит по каждому элемент
    void forEach(List<String> list, Consumer<String> consumer) {
        for (String element : list) {
            consumer.accept(element);
        }
    }

    public static void main(String[] args) {

        Test test = new Test();

        List<String> strings = List.of("Hello", "Eminem", "Java", "Durka");

        //делаю для проверки, по идеи должны быть все элементы
        System.out.println(strings);


        // печатаем каждый элемент
        test.forEach(strings, element -> System.out.println(element));

    }
}
