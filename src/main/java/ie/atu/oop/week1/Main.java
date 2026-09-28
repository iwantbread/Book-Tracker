package ie.atu.oop.week1;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            Book myBook = new Book("Dune", "Frank", 412);
            System.out.println(myBook.getTitle());
            System.out.println(myBook.getAuthor());
            System.out.println(myBook.getPageCount());
        }

        catch(IllegalArgumentException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}