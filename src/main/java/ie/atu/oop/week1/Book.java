package ie.atu.oop.week1;

public class Book {
    public String title;
    public String author;
    public int pageCount;

    private BookStatus status;

    public Book(String title, String author, int pageCount)
    {
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        if (author == null || author.isBlank())
        {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }

        if (pageCount < 1)
        {
            throw new IllegalArgumentException("Page count cannot be less than 1");
        }

        this.status = BookStatus.AVAILABLE;

        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public enum BookStatus
    {
        AVAILABLE,
        ON_LOAN
    }

    public BookStatus getStatus()
    {
        return status;
    }

    public void borrowBook()
    {
        if (status == BookStatus.ON_LOAN)
        {
            throw new IllegalStateException("Book has already been borrowed");
        }
        status = BookStatus.ON_LOAN;
    }

    public void returnBook() {
        if (status == BookStatus.AVAILABLE) {
            throw new IllegalStateException("Book is already available.");
        }
        if (status == BookStatus.ON_LOAN) {
            status = BookStatus.AVAILABLE;
        }
    }
}