package lessons.lessons2;
import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число N: ");
        int N = scanner.nextInt();

        if (N < 0) {
            System.out.println("Ошибка: факториал определён только для неотрицательных чисел.");
        } else {
            long factorial = 1; // используем long, т.к. значения быстро растут
            for (int i = 1; i <= N; i++) {
                factorial *= i;
            }
            System.out.println("Факториал числа " + N + " = " + factorial);
        }
    }
}
//тут тоже самое, что и в задании 3, только переменные названы по другому
