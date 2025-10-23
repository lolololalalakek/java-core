package Lesson12.SecondPart.CheckingNumbers;

import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {


        // Получи Predicate, который проверяет "нечётное или отрицательное".
        Predicate<Integer> isEven = element -> element % 2 != 0;
        Predicate<Integer> isPositive = element -> element<0;

        System.out.println(isEven.or(isPositive).test(59));
    }
}
