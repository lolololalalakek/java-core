package lessons.lessons2;

import java.util.Scanner;

public class DetermitionNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println("Ваше число " + number + " - четное");
        } else {
            System.out.println("Ваше число " + number + " - нечетное");
        }
    }
}
