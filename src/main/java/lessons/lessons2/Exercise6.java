package lessons.lessons2;
import java.util.Scanner;
public class Exercise6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число (можно отрицательное): ");
        int number = scanner.nextInt();

        int sign = number < 0 ? -1 : 1; // определяем знак
        int temp = Math.abs(number);    // работаем с модулем числа
        int reversed = 0;

        while (temp != 0) {
            int digit = temp % 10;             // берём последнюю цифру
            reversed = reversed * 10 + digit;  // добавляем её к результату
            temp /= 10;                        // убираем последнюю цифру
        }

        reversed *= sign; // восстанавливаем знак числа

        System.out.println("Развёрнутое число: " + reversed);
    }
}

