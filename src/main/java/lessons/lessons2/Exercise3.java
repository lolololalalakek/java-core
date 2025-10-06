package lessons.lessons2;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число N: ");
        int N = scanner.nextInt();

        // Проверка на отрицательное число
        if (N < 0) {
            System.out.println("Нельзя вводить отрицательные числа!");
            return; // Завершаем программу
        }

        long product = 1L; // используем long, чтобы не выйти за пределы int
        for (int i = 1; i <= N; i++) {
            product *= i;
        }

        System.out.println("Произведение чисел от 1 до " + N + " = " + product);
    }
}
// тип данных Long занимает больше памяти (8 байт вместо 4 у int), но это несущественно
// производительность на современных JVM почти не страдает
