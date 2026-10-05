package ie.atu.oop.week1;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private static final int MAX_LOAN_DAYS = 14;
    private final List<Book> books = new ArrayList<Book>();

    public void loanBook(Book book, int loanDays) {
        if (book == null) {
            throw new IllegalArgumentException(
                    "Book must not be null");
        }
        if (loanDays < 1 || loanDays > MAX_LOAN_DAYS) {
            throw new IllegalArgumentException(
                    "Loan days must be from 1 to 14");
        }
        book.borrowBook();
    }
    public void returnBook(Book book){
        if (book == null) {
            throw new IllegalArgumentException (
                    "Book must not be null");
        }
        book.returnBook();
    }
    public void addBook(Book book){
        if (book == null) {
            throw new IllegalArgumentException(
                    "Book must not be null");
        }

        books.add(book);
    }

    public boolean removeBook(String title) {
        Book book = findBookByTitle(title);

        if (book == null) {
            return false;
        }

        books.remove(book);
        return true;
    }

    public int getBookCount() {
        return books.size();
    }

    public List<Book>getAllBooks() {
        return new ArrayList<>(books);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
