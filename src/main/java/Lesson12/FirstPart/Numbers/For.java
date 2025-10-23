package Lesson12.FirstPart.Numbers;

import java.util.List;

public class For {
    public static void main(String[] args) {
        List<Integer> numbers = List.of( 1, 2, 3, 4, 5, 6);

        for (int number : numbers) {
            if (number % 2 == 0) {
                int numberInSquare = number * number;
                System.out.println(numberInSquare);
            }
        }
    }

}
