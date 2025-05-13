package MongoDB.SOLID;

// Design a simple library system following all SOLID principles with at least 2-3classes/interfaces
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
// S - Single Responsibility Principle
// Each class should have only one reason to change.

// IBook interface defines the core properties of a book.
interface IBook {
    String getTitle();
    String getAuthor();
    String getIsbn();
}

// Book class implements IBook and holds book details.
class Book implements IBook {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

// O - Open/Closed Principle
// Classes should be open for extension but closed for modification.
// ILibraryCatalog interface for managing book collections.
interface ILibraryCatalog {
    void addBook(IBook book);
    void removeBook(String isbn);
    IBook findBook(String isbn);
    List<IBook> getAllBooks();
}

// LibraryCatalog class implements ILibraryCatalog and manages books.
class LibraryCatalog implements ILibraryCatalog {
    private List<IBook> books = new ArrayList<>();

    public void addBook(IBook book) {
        if (book != null) { // Added null check
            books.add(book);
        }
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public IBook findBook(String isbn) {
        for (IBook book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<IBook> getAllBooks() {
        return books;
    }
}

// L - Liskov Substitution Principle
// Subtypes must be substitutable for their base types.
//  Not directly applicable here, but the use of interfaces
//  helps ensure that any class implementing them can be
//  used wherever the interface is expected.

// IBorrowable interface for items that can be borrowed
interface IBorrowable {
    void borrowItem();
    void returnItem();
    boolean isAvailable();
}

// Abstract class for items that can be borrowed
abstract class LibraryItem implements IBook, IBorrowable {  //correct implementation
    private boolean isAvailable = true;
    private String title;
    private String author;
    private String isbn;

    public LibraryItem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void borrowItem() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("Item is not available");
        }
    }

    public void returnItem() {
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

// Book class now extends LibraryItem and implements IBook
class BookV2 extends LibraryItem {

    public BookV2(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + getIsbn() + ", Available: " + isAvailable();
    }
}

// D - Dependency Inversion Principle
// Depend upon abstractions, not concretions.
//  The LibraryCatalog depends on the IBook interface,
//  not on the concrete Book class.  This allows for
//  different types of books or other media to be added
//  to the catalog without modifying the LibraryCatalog.

public class LibrarySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ILibraryCatalog catalog = new LibraryCatalog();

        // Add some books
        catalog.addBook(new BookV2("The Lord of the Rings", "J.R.R. Tolkien", "978-0547928227"));
        catalog.addBook(new BookV2("Pride and Prejudice", "Jane Austen", "978-0141439518"));
        catalog.addBook(new BookV2("1984", "George Orwell", "978-0451524935"));

        // Main loop for user interaction
        while (true) {
            System.out.println("\n--- Library System Menu ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Find a Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Borrow a Book");
            System.out.println("6. Return a Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1; // Initialize to an invalid value
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.next(); // Consume the invalid input
                continue; // Restart the loop
            }
            scanner.nextLine(); // Consume the newline character after reading the integer.

            switch (choice) {
                case 1:
                    // Get book details from the user
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    // Create a new book object
                    IBook newBook = new BookV2(title, author, isbn); // Use BookV2
                    catalog.addBook(newBook); // Add the book to the catalog
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    // Get the ISBN of the book to remove
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    catalog.removeBook(isbnToRemove);
                    System.out.println("Book removed successfully (if it existed).");
                    break;
                case 3:
                    // Get the ISBN of the book to find
                    System.out.print("Enter ISBN of the book to find: ");
                    String isbnToFind = scanner.nextLine();
                    IBook foundBook = catalog.findBook(isbnToFind);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    // Show all books in the catalog
                    List<IBook> allBooks = catalog.getAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("The catalog is empty.");
                    } else {
                        System.out.println("\n--- All Books in the Catalog ---");
                        for (IBook book : allBooks) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String isbnToBorrow = scanner.nextLine();
                    IBook bookToBorrow = catalog.findBook(isbnToBorrow);
                    if (bookToBorrow instanceof IBorrowable) {
                        if (((IBorrowable) bookToBorrow).isAvailable()) {
                            ((IBorrowable) bookToBorrow).borrowItem();
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Book is currently unavailable.");
                        }
                    } else {
                        System.out.println("Book is not borrowable.");
                    }
                    break;
                case 6:
                    System.out.print("Enter ISBN of the book to return: ");
                    String isbnToReturn = scanner.nextLine();
                    IBook bookToReturn = catalog.findBook(isbnToReturn);
                    if (bookToReturn instanceof IBorrowable) {
                        ((IBorrowable) bookToReturn).returnItem();
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book is not returnable.");
                    }
                    break;
                case 7:
                    // Exit the program
                    System.out.println("Exiting the Library System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

