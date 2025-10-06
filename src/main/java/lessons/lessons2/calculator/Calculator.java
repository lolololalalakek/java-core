package lessons.lessons2.calculator;

public class Calculator {


    public int calculate (int first, int second, char sign) {

        return switch (sign ) {
            case '+' -> (first + second);
            case '-' -> (first - second);
            case '/', ':' -> (first / second);
            case '*' -> (first * second);
            default -> throw new RuntimeException("Invalid command");
        };
    }

}
