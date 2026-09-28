package ie.atu.oop.week1;

public class Main {
    public static void main(String[] args)
    {
        Book book = new Book("Dune", "Frank Herbert",412);
        book.borrowBook();
        try
        {
            book.borrowBook();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(book.getStatus());
        try
        {
            Book myBook = new Book("Dune", "Frank", 412);
            System.out.println(myBook.getTitle());
        }

        catch(IllegalArgumentException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}