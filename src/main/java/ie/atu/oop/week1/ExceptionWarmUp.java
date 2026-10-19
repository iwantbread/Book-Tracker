package ie.atu.oop.week1;

import java.util.Scanner;

public class ExceptionWarmUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter a page count: ");
            String text = scanner.nextLine();
            try {
                int pageCount = Integer.parseInt(text);
                System.out.println("Page count = " + pageCount);
                valid = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("Please enter a whole number.");
            }
        }
        System.out.println("Program continues.");
    }
}
