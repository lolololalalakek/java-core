package lessons.lessons2.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int secondNumber = scanner.nextInt();

        System.out.println("Введите операцию: ");
        char sign = scanner.next().charAt(0);

        Calculator calc1 = new Calculator();

        int result = calc1.calculate(firstNumber, secondNumber, sign);

        System.out.println(result);
    }
}
