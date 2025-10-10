package lessons.lessons3.book;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {

    private int isbn;
    private String name;
    private String author;
    private int year;
    private BookStatus status;

}
