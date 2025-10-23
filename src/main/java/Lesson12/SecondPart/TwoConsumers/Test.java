package Lesson12.SecondPart.TwoConsumers;

import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = element -> System.out.println("Element is: "+ element);
        Consumer<String> intConsumer = element -> System.out.println("Length of element is: " +element.length());

        stringConsumer.andThen(intConsumer).accept("Eminem");
        stringConsumer.andThen(intConsumer).accept("Miami heat");
    }
}
