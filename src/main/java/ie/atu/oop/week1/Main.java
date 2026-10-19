package ie.atu.oop.week1;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        LibraryService service = new LibraryService();
        BookFileStore store = new BookFileStore(
                Path.of("data", "books.csv"));

        try {
            for (Book book : store.load()) {
                service.addBook(book);
            }
            System.out.println("Loaded: " + service.getBookCount());
        }
        catch (IOException ex) {
            System.out.println("Load failed: " + ex.getMessage());
            return;
        }

        if (service.getBookCount() == 0) {
            Book dune = new Book("Dune", "Frank Herbert", 412);
            Book cleanCode = new Book(
                    "Clean Code", "Robert C. Martin", 464);

            service.addBook(dune);
            service.addBook(cleanCode);
            service.loanBook("Dune", 7);
        }

        for (Book book : service.getBooks()) {
            System.out.println(
                    book.getTitle() + " - " +
                            book.getStatus());
        }

        try {
            store.save(service.getBooks());
            System.out.println("Saved: " + service.getBookCount());
        }
        catch (IOException ex) {
            System.out.println("Save failed: " + ex.getMessage());
        }
    }
}