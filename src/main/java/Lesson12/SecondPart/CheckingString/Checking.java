package Lesson12.SecondPart.CheckingString;

import java.util.function.Predicate;

public class Checking {
    public static void main(String[] args) {

        Predicate<String> check = element -> element != null && element.length() > 3;

        System.out.println(check.test("HEY"));
        System.out.println(check.test("RAMBO"));
        System.out.println(check.test("Eminem"));
        System.out.println(check.test(null));
        System.out.println(check.test("or"));
    }
}
