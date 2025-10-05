package lessons.lessons2;

public class Exercise1 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%4d", i);   // 3 позиции для каждого числа
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}


