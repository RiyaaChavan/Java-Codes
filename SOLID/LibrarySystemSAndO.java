package MongoDB.SOLID;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// S - Single Responsibility Principle
// Each class should have only one reason to change.
// IBook and Book class remain same as they have single responsibility

// O - Open/Closed Principle
// Classes should be open for extension but closed for modification.
interface ILibraryCatalog {
    void addBook(IBook book);
    List<IBook> getAllBooks();
}
class LibraryCatalog implements ILibraryCatalog {
    private List<IBook> books = new ArrayList<>();
    public void addBook(IBook book) {
        if (book != null) {
            books.add(book);
        }
    }
    public List<IBook> getAllBooks() {
        return books;
    }
}

public class LibrarySystemSAndO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ILibraryCatalog catalog = new LibraryCatalog();

        // Adding some initial books
        catalog.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0547928227"));
        catalog.addBook(new Book("Pride and Prejudice", "Jane Austen", "978-0141439518"));
        
        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("\nDo you want to add a book to the catalog? (yes/no)");
            String choice = scanner.nextLine();
            
            if (choice.equalsIgnoreCase("yes")) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                
                System.out.print("Enter author name: ");
                String author = scanner.nextLine();
                
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                
                catalog.addBook(new Book(title, author, isbn));
                System.out.println("Book added successfully!");
            } else {
                continueAdding = false;
            }
        }

        List<IBook> allBooks = catalog.getAllBooks();
        System.out.println("\n--- All Books in the Catalog ---");
        for (IBook book : allBooks) {
            System.out.println(book);
        }
        scanner.close();
    }
}