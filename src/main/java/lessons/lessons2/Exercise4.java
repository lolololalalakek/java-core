package lessons.lessons2;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число N: ");
        int N = scanner.nextInt();
        int sum = 0;

        for (int i = 2; i <= N; i += 2) { // только чётные числа
            sum += i;
        }
        System.out.println("Сумма чётных чисел от 1 до " + N + " = " + sum);
    }
}
//начинаем с двух, и прибавляем 2
