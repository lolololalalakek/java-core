package lessons.lessons3.book;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Library {

    private HashMap<Integer, Book> books;


    public Book getBookInfo(int isbn) {
        return books.get(isbn);
    }


    public ArrayList<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public void addNewBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void reserveBook(int isbn) {
        Book book = getBookInfo(isbn);
        book.setStatus(BookStatus.RESERVED);
    }

}
