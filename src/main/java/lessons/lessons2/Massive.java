package lessons.lessons2;

import java.util.Scanner;

public class Massive {
    // метод для вычисления среднего
    public static double calcAverage(double[] arr) {
        double sum = 0;
        for (double v : arr) {
            sum = sum + v;
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Сколько чисел будет? ");
        int n = sc.nextInt();

        double[] numbers = new double[n]; // массив

        System.out.println("Напишите числа для массива: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextDouble(); // ввод каждого числа
        }

        double average = calcAverage(numbers); // вызываем метод

        System.out.println("Среднее значение: " + average);
    }
}
