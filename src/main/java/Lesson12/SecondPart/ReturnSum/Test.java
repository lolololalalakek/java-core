package Lesson12.SecondPart.ReturnSum;

import java.util.function.BiFunction;

public class Test {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(5, 7)); // 12
        System.out.println(sum.apply(10, 20)); // 30
    }
}
