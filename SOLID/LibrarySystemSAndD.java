package MongoDB.SOLID;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// S - Single Responsibility Principle
// Each class should have only one reason to change.
// IBook and Book class remain same.

// D - Dependency Inversion Principle
// Depend upon abstractions, not concretions.
interface IBookService {
     List<IBook> getAllBooks();
     void addBook(IBook book);
}

class BookService implements IBookService{
    private List<IBook> books;
     public BookService(List<IBook> books){
        this.books = books;
    }
    public List<IBook> getAllBooks(){
        return this.books;
    }
    public void addBook(IBook book) {
        if (book != null) {
            this.books.add(book);
        }
    }
}

public class LibrarySystemSAndD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<IBook> initialBooks = new ArrayList<>();
        initialBooks.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0547928227"));
        initialBooks.add(new Book("Pride and Prejudice", "Jane Austen", "978-0141439518"));

        IBookService bookService = new BookService(initialBooks);
        
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
                
                bookService.addBook(new Book(title, author, isbn));
                System.out.println("Book added successfully!");
            } else {
                continueAdding = false;
            }
        }

        List<IBook> allBooks = bookService.getAllBooks();
        System.out.println("\n--- All Books in the Catalog ---");
        for (IBook book : allBooks) {
            System.out.println(book);
        }
        scanner.close();
    }
}