package lessons.lessons8;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@AllArgsConstructor
class Book {
    String name;
    String author;
    String isbn;


    @Override
    public String toString() {
        return name + " — " + author + " (ISBN: " + isbn + ")";
    }
}

public class BookMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Book> books = new HashMap<>();
        books.put("978-5-17-080193-5", new Book("Мастер и Маргарита", "М. Булгаков", "978-5-17-080193-5"));
        books.put("978-5-389-07407-2", new Book("Преступление и наказание", "Ф. Достоевский", "978-5-389-07407-2"));
        books.put("978-5-699-97304-8", new Book("Норвежский лес", "Х. Мураками", "978-5-699-97304-8"));

        System.out.println("Список книг:");
        books.values().forEach(System.out::println);

        sc.close(); // пусть даже не используется — хорошая практика
    }
}

