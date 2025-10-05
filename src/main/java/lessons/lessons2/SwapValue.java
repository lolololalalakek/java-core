package lessons.lessons2;

import java.util.Scanner;

public class SwapValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int secondNumber = scanner.nextInt();

        int container = firstNumber;
        firstNumber = secondNumber;
        secondNumber = container;

        System.out.println("После обмена: ");
        System.out.println();
        System.out.println("Первое число: " + firstNumber);
        System.out.println();
        System.out.println("Второе число: " + secondNumber);


    }
}
