# Book Tracker

A simple Java program demonstrating basic object-oriented programming concepts. The program creates Book objects, displays their details, and allows a book to be borrowed or returned by changing its availability.

## Lab 3

### Package

The Java package used is `ie.atu.oop.week1`.

### Constructor Checks

The constructor checks if the title or author are null before using `isBlank()`. This is because `isBlank()` cannot be called on a null value and would cause an error.

### Final Fields and Status

The title, author and pageCount are final because they should not change after a Book is created. Status is not final because it needs to change between AVAILABLE and ON_LOAN when a book is borrowed or returned.

### Book Status

I used `borrowBook()` and `returnBook()` instead of a status setter so that the Book class can check if the requested change is allowed. A setter could change the status directly without these checks.

### Class Responsibilities

Book checks its own details and controls whether its status can change. LibraryService checks requests such as whether the Book is null and whether the loan is between 1 and 14 days. It then passes valid requests to Book.

### Testing

A valid 7 day loan successfully changed the status from AVAILABLE to ON_LOAN. A 15 day loan was rejected and the Book remained AVAILABLE. Trying to return an already available Book was rejected and it remained AVAILABLE. The Maven package build completed with BUILD SUCCESS.

### Debugger Observations

The 7 day instance reached the `borrowBook` method because it passed the if statement check of between 1 and 14, so it could move on to `book.borrowBook()`. The 15 day instance failed this check because it was outside the allowed range. This caused an `IllegalArgumentException` before it could reach the `borrowBook` method. The first book was AVAILABLE before the 15 day attempt because it had already been returned using `service.returnBook(first)`.

### AI Assistance

I used ChatGPT to help explain the lab instructions, Git commands, Markdown formatting and to check code and test results that I had written.

## How to Run

Open the project in IntelliJ IDEA and run the `Main` class.

## JDK Version

JDK 21