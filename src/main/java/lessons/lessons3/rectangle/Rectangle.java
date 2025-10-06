package lessons.lessons3.rectangle;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor //создает конструкторы под поля, которые мы задаем
@NoArgsConstructor // создает дефолтный конструктор, который не принимает в себя поля
@Getter
@Setter
@EqualsAndHashCode
public class Rectangle {

    private double length;
    private double width;

    public double calculateSquare () {
        return length * width;
    }

    public double calculatePerimiter () {
        return (length + width) * 2;
    }


}
