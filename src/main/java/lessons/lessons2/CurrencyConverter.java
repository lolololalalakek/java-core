package lessons.lessons2;

public class CurrencyConverter {

    public static void converter (double uzbekSum) {
        int exchange = 12500;
        double total = uzbekSum * exchange;
        System.out.println(total);


    }
    public static void main(String[] args) {
        converter(25.115);

    }
}
