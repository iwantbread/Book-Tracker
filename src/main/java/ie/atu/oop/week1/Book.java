package ie.atu.oop.week1;

public class Book {
    public String title;
    public String author;
    public int pageCount;
    public boolean available = true;

    public void displayDetails() {
        System.out.println(title + " by " + author);
        System.out.println(pageCount + " pages");
        System.out.println("Available: " + available);
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already on loan.");
        }
    }
}