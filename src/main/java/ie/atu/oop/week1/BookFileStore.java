package ie.atu.oop.week1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BookFileStore {

    private final Path file;

    public BookFileStore(Path file) {
        this.file = file;
    }

    private String toCsvRow(Book book) {
        return book.getTitle() + ","
                + book.getAuthor() + ","
                + book.getPageCount() + ","
                + book.getStatus();
    }
    public void save(List<Book> books) throws IOException {
        Files.createDirectories(file.getParent());

        List<String> lines = new ArrayList<>();
        lines.add("title,author,pageCount,status");

        for (Book book : books) {
            lines.add(toCsvRow(book));
        }

        Files.write(file, lines);
    }
}
