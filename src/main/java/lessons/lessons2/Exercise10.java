package lessons.lessons2;

public class Exercise10 {
    public static void main(String[] args) {
        int n = 4; // количество строк в каждом треугольнике

        // Верхняя часть
        for (int i = 1; i <= n; i++) {
            // Левый треугольник (растёт)
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Пробелы между треугольниками
            System.out.print("   \t"); // можно настроить

            // Правый треугольник (убывает)
            for (int j = n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println(); // пустая строка

        // Нижняя часть
        for (int i = n; i >= 1; i--) {
            // Левый треугольник (убывает)
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Пробелы
            System.out.print("   \t");

            // Правый треугольник (растёт)
            for (int j = i; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
