package lessons.lessons8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ElectronicQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int counter = 1;

        while (true) {
            System.out.println("\n1 - Добавить пользователя");
            System.out.println("2 - Обработать следующего");
            System.out.println("3 - Показать очередь");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");
            int choice = sc.nextInt();
            sc.nextLine(); // очистка буфера

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите имя пользователя: ");
                    String name = sc.nextLine();
                    String ticket = "#" + counter++ + " - " + name;
                    queue.add(ticket);
                    System.out.println("Пользователь добавлен: " + ticket);
                }
                case 2 -> {
                    if (queue.isEmpty()) System.out.println("Очередь пуста!");
                    else System.out.println("Обслужен: " + queue.poll());
                }
                case 3 -> {
                    if (queue.isEmpty()) System.out.println("Очередь пуста!");
                    else {
                        System.out.println("Текущая очередь:");
                        queue.forEach(System.out::println);
                    }
                }
                case 0 -> {
                    System.out.println("Выход...");
                    sc.close(); // закрываем сканнер при завершении программы
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }
}

