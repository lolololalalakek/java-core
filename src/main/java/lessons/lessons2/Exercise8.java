package lessons.lessons2;

public class Exercise8 {


    public static void main(String[] args) {

        int number = 1001; // начинаем сразу с 1001, так как 1000 не делится на 7
        while (number % 7 != 0) {
            number++;
        }

        System.out.println("Первое число, которое делится на 7 и больше 1000: " + number);
    }
}
