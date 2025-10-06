package lessons.lessons3.book;


import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Book firstBook = new Book(15623, "Норвежский лес", "Харуки Мураками", 1987, BookStatus.NOT_RESERVED);
        Book secondBook = new Book(12345, "Ночь нежна", "Френсис Скотт Фицджеральд", 1934, BookStatus.RESERVED );

        Library library = new Library(new HashMap<>());
        library.addNewBook(firstBook);
        library.addNewBook(secondBook);

        System.out.println(library.getBooks());

        library.reserveBook(firstBook.getIsbn());
        System.out.println(library.getBooks());

        Book bookUpdated = library.getBookInfo(firstBook.getIsbn());
        System.out.println(bookUpdated);
    }
}
