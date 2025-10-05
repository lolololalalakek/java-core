package lessons.lessons3.rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle firstRectangle = new Rectangle(11.05, 12.05);

        double perimiter = firstRectangle.calculatePerimiter();
        System.out.println(perimiter);

        double square = firstRectangle.calculateSquare();
        System.out.println(square);
    }
}
