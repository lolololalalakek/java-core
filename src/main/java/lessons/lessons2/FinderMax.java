package lessons.lessons2;

import java.util.Scanner;

public class FinderMax {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int secondNumber = scanner.nextInt();

        System.out.println("Введите третье число: ");
        int thirdNumber = scanner.nextInt();

        if (firstNumber > secondNumber & firstNumber > thirdNumber) {
            System.out.println("Самое большое число: " + firstNumber);
        }
        if (secondNumber > firstNumber & secondNumber > thirdNumber) {
            System.out.println("Самое большое число: " + secondNumber);
        }
        if (thirdNumber > secondNumber & thirdNumber > firstNumber) {
            System.out.println("Самое большое число: " + thirdNumber);
        }

    }
}
