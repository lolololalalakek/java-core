package lessons.lessons3.car;

import static lessons.lessons3.car.Car.printCarInfo;

public class Main {

    public static void main(String[] args) {
        Car firstCar = new Car("Japan", "Toyota Hillux", 2023);
        Car secondCar = new Car("Germany", "Porsche 911 Turbo", 2000);

        printCarInfo(firstCar);
        System.out.println();
        printCarInfo(secondCar);
    }

}
