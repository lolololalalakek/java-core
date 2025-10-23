package Lesson12.SecondPart.ConsumerString;

import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {

        Consumer<String> consumer = element -> System.out.println(element.toUpperCase());

        consumer.accept("HelLo");
        consumer.accept("eminem");
        consumer.accept("ANgelina djoli");
    }
}
