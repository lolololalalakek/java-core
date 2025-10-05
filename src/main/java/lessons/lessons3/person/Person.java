package lessons.lessons3.person;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Person {

    private String name;
    private int age;

    public void introduce() {
        System.out.println("My name is " + name + ", " + ", I'm " +age + " years old");
    }
}
