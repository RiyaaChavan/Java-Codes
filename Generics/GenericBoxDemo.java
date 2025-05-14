// Q: Create a Generic Box Class
// Create a class that stores objects of any type and prints the content.

import java.util.Scanner;

// Generic Box class
class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void printContent() {
        System.out.println("Box contains: " + content);
    }
}

public class GenericBoxDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String Box
        Box<String> stringBox = new Box<>();
        System.out.print("Enter a string to store in String Box: ");
        String str = scanner.nextLine();
        stringBox.setContent(str);
        stringBox.printContent();

        // Integer Box
        Box<Integer> intBox = new Box<>();
        System.out.print("Enter an integer to store in Integer Box: ");
        int num = scanner.nextInt();
        intBox.setContent(num);
        intBox.printContent();

        scanner.close();
    }
}
