package ie.atu.oop.week1;

public class BookExceptionCheck {
    public static void main(String[] args) {
        try {
            Book invalid = new Book("Dune", "Frank Herbert", 412);
            System.out.println(invalid.getTitle());
        } catch (IllegalArgumentException ex) {
            System.out.println("Book rejected: " + ex.getMessage());
        }
    }
}
