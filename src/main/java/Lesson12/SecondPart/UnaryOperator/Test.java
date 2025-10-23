package Lesson12.SecondPart.UnaryOperator;

import java.util.function.UnaryOperator;

public class Test {
    public static void main(String[] args) {

        //Создай UnaryOperator<String>, который добавляет "!!!" к строке.
        UnaryOperator<String> unary = element -> element + "!!!";

        System.out.println(unary.apply("Eminem"));
        System.out.println(unary.apply("Denzel Curry"));
        System.out.println(unary.apply("Pugacheva"));
    }
}
