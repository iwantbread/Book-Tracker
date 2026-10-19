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

I used AI to help explain the lab instructions, Git commands, Markdown formatting and to check code and test results that I had written.


## Lab 4 - Collections

### Collections

LibraryService now stores multiple books in a `List<Book>` using an ArrayList. `List<Book>` tells the compiler the list contains Book objects. The list is final, meaning it can't be replaced, but books can still be added or removed.

The enhanced for loop goes through each Book in the list one at a time.

### Searching and Removing

`findBookByTitle()` returns the matching Book or null if it isn't found. I used `equalsIgnoreCase()` so capital letters don't matter.

`removeBook()` uses the search method rather than repeating the same code.

### Class Responsibilities

Main creates books and displays results. LibraryService manages the collection, searches for books and checks loan durations. Book controls its own status.

### Testing

Three books were added successfully. Dune was found, borrowed and returned. A missing book returned false when loaning. Removing Clean Code worked the first time but returned false the second time. Final count was 2.

Maven package completed with BUILD SUCCESS.

### Debugger

The debugger can be used to check the list size before and after adding a book and follow the search loop until a match is found or null is returned.

### AI Assistance

I used AI to help explain the instructions, troubleshoot errors, check my code and test results.


## Lab 5 - Exceptions and CSV File Persistence

### Exception Handling

In `ExceptionWarmUp`, I used `try` and `catch` to handle invalid input. Entering `abc` caused a `NumberFormatException`, which was caught and allowed the user to try again. Entering `412` worked and ended the loop.

I also tested the Book constructor. `Book` throws an `IllegalArgumentException` if the title is empty, and `BookExceptionCheck` catches it and prints the error message. Changing the title to Dune allowed the Book to be created.

### Path and Files

`Path` represents the location of a file, while `Files` provides methods to interact with it. Creating a Path does not create the actual file.

I used `Files.createDirectories()` to create the data folder and `Files.write()` to write information to `books.csv`.

### CSV Saving and Loading

I created a `BookFileStore` class to handle saving and loading books.

`toCsvRow()` converts a Book object into a CSV string, while `fromCsvRow()` converts a CSV string back into a Book object.

The `save()` method writes the books to `data/books.csv`, and `load()` reads the file and recreates the Book objects, including their availability status.

I added `getBooks()` to LibraryService, which returns a new ArrayList containing the books rather than exposing the original list.

### Testing

I deleted `books.csv` and ran Main. It loaded 0 books, created two books and saved them to the CSV file.

Running Main again loaded both books successfully. Dune retained its ON_LOAN status and Clean Code remained AVAILABLE.

I also changed Dune's page count from 412 to `four hundred`. This caused a `NumberFormatException` in `BookFileStore.java` because the text could not be converted into an integer. I restored the page count to 412 and the program ran successfully with exit code 0.

### Debugger

The debugger can be used to inspect the list of CSV lines in `load()` and the individual values created by splitting a row in `fromCsvRow()`.

The exception stack trace showed that the error occurred in `fromCsvRow()` at line 43, which was called by `load()` at line 69 and Main at line 13.

### AI Assistance

I used AI to help explain Java concepts, troubleshoot Git merge conflicts, and check code and test results.

## How to Run

Open the project in IntelliJ IDEA and run the `Main` class.

## JDK Version

JDK 21