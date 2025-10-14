package lessons.lessons8;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите набор чисел через пробел: ");
        String input = sc.nextLine();

        Set<Integer> unique = new LinkedHashSet<>();
        for (String s : input.split(" ")) {
            if (!s.isBlank()) unique.add(Integer.parseInt(s));
        }

        System.out.println("Уникальные числа: " + unique);
        sc.close(); // закрываем после использования
    }
}

