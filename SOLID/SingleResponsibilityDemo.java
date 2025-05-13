// Q: Apply Single Responsibility Principle
// Design a class that performs one specific task like handling user input or processing data.

package MongoDB.SOLID;
import java.util.Scanner;

// Class 1: Handles user input only (SRP)
class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public String getUserName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public int getUserAge() {
        System.out.print("Enter your age: ");
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}

// Class 2: Handles processing/display logic (SRP)
class DataProcessor {
    public void displayUserInfo(String name, int age) {
        System.out.println("\nUser Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if (age >= 18) {
            System.out.println("Status: Adult");
        } else {
            System.out.println("Status: Minor");
        }
    }
}

// Main class to connect the flow
public class SingleResponsibilityDemo {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String name = inputHandler.getUserName();
        int age = inputHandler.getUserAge();
        inputHandler.closeScanner();

        DataProcessor processor = new DataProcessor();
        processor.displayUserInfo(name, age);
    }
}
