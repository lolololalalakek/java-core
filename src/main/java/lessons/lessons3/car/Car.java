package lessons.lessons3.car;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Car {

    private String country;
    private String model;
    private int yearOfManufacture;

    public static void printCarInfo (Car car) {
        System.out.println("Страна производства: "+car.country);
        System.out.println("Модель машины: " + car.model);
        System.out.println("Год выпуска - "+ car.yearOfManufacture);
    }
}
