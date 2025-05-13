package MongoDB.SOLID;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// L - Liskov Substitution Principle
// Subtypes must be substitutable for their base types.
// IBook and Book remain same.

// I - Interface Segregation Principle
// A client should not be forced to implement an interface it doesn't use.
interface IBookCatalog {  //renamed
    void addBook(IBook book);
    IBook findBook(String isbn);
    List<IBook> getAllBooks();
}
interface IBorrowableItem { //new interface
    void borrowItem();
    void returnItem();
    boolean isAvailable();
}

class LibraryCatalogLI implements IBookCatalog { //renamed
    private List<IBook> books = new ArrayList<>();

    public void addBook(IBook book) {
        if (book != null) {
            books.add(book);
        }
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
//implements both
class BorrowableBook extends Book implements IBorrowableItem{
    private boolean isAvailable = true;

    public BorrowableBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }


    public void borrowItem() {
        if (isAvailable) {
            isAvailable = false;
        }
         else {
            System.out.println("Book is not available");
        }
    }

    public void returnItem() {
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

     @Override
    public String toString() {
        return "Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + getIsbn() + ", Available: " + isAvailable();
    }
}

public class LibrarySystemLAndI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IBookCatalog catalog = new LibraryCatalogLI();

        // Adding some initial books
        BorrowableBook book1 = new BorrowableBook("The Lord of the Rings", "J.R.R. Tolkien", "978-0547928227");
        BorrowableBook book2 = new BorrowableBook("Pride and Prejudice", "Jane Austen", "978-0141439518");
        catalog.addBook(book1);
        catalog.addBook(book2);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Library System Menu ===");
            System.out.println("1. Add a new book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. View all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch (choice) {
                case 1: // Add a new book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    
                    BorrowableBook newBook = new BorrowableBook(title, author, isbn);
                    catalog.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;
                    
                case 2: // Borrow a book
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    IBook bookToBorrow = catalog.findBook(borrowIsbn);
                    
                    if (bookToBorrow != null && bookToBorrow instanceof IBorrowableItem) {
                        IBorrowableItem borrowable = (IBorrowableItem) bookToBorrow;
                        if (borrowable.isAvailable()) {
                            borrowable.borrowItem();
                            System.out.println("Book borrowed successfully!");
                        } else {
                            System.out.println("Book is not available for borrowing.");
                        }
                    } else {
                        System.out.println("Book not found or not borrowable.");
                    }
                    break;
                    
                case 3: // Return a book
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.nextLine();
                    IBook bookToReturn = catalog.findBook(returnIsbn);
                    
                    if (bookToReturn != null && bookToReturn instanceof IBorrowableItem) {
                        IBorrowableItem borrowable = (IBorrowableItem) bookToReturn;
                        if (!borrowable.isAvailable()) {
                            borrowable.returnItem();
                            System.out.println("Book returned successfully!");
                        } else {
                            System.out.println("This book was not borrowed.");
                        }
                    } else {
                        System.out.println("Book not found or not borrowable.");
                    }
                    break;
                    
                case 4: // View all books
                    List<IBook> allBooks = catalog.getAllBooks();
                    System.out.println("\n--- All Books in the Catalog ---");
                    for (IBook book : allBooks) {
                        System.out.println(book);
                    }
                    break;
                    
                case 5: // Exit
                    exit = true;
                    System.out.println("Thank you for using the Library System!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}