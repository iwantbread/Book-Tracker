package ie.atu.oop.week1;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        Book dune = new Book("Dune", "Frank Herbert", 412);
        Book cleanCode = new Book(
                "Clean Code", "Robert C. Martin", 464);

        service.addBook(dune);
        service.addBook(cleanCode);
        service.loanBook("Dune", 7);

        BookFileStore store = new BookFileStore(
                Path.of("data", "books.csv"));

        try {
            store.save(service.getBooks());
            System.out.println("Saved: " + service.getBookCount());
        }
        catch (IOException ex) {
            System.out.println("Save failed: " + ex.getMessage());
        }
    }
}