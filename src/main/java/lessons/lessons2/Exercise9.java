package lessons.lessons2;

import java.util.Scanner;

public class Exercise9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число N: ");
        int N = scanner.nextInt();

        if (N < 2) {
            System.out.println("Простых чисел до " + N + " нет.");
            return;
        }

        System.out.println("Простые числа до " + N + ":");
        for (int i = 1; i <= N; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

        // Метод для проверки, простое ли число
    public static boolean isPrime(int number) {
        if (number < 1) return false;
            // Проверяем делители от 2 до number
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // нашли делитель — число не простое
            }
        }
        return true; // делителей нет — простое
    }
}
