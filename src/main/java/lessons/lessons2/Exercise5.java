package lessons.lessons2;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите положительное число: ");
        int number = scanner.nextInt();

        if (number < 0) { //проверка на отрицательное число.
            System.out.println("Ошибка: число должно быть положительным.");
        } else {
            int sum = 0;
            int temp = number;

            while (temp > 0) {
                sum += temp % 10; // прибавляем последнюю цифру
                temp /= 10;       // убираем последнюю цифру
            }

            System.out.println("Сумма цифр числа " + number + " = " + sum);
            }
        }
    }
