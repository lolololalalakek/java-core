package Lesson12.SecondPart.MethodGenerate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Test {

    // метод создаёт список из n элементов, полученных от supplier
    List<String> generate(Supplier<String> supplier, int n) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(supplier.get());
        }

        return list;
    }

    public static void main(String[] args) {

        Test test = new Test();

        // создаём список из 5 одинаковых элементов
        List<String> words = test.generate(() -> "Eminem", 5);

        System.out.println(words);
    }
}
