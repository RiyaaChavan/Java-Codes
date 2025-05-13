//q: Create an interface with a default greeting method and override it in implementing class.
import java.util.Scanner;

// Interface with a default method
interface Greeter {
    // Abstract method (must be implemented by implementing classes)
    void greet(String name);

    // Default method (implementing classes can use or override it)
    default void sayHello(String name) {
        System.out.println("Hello, " + name + "! Welcome!");
    }
}

// Implementing class
class WelcomeMessage implements Greeter {
    private String customGreeting;

    public WelcomeMessage(String customGreeting) {
        this.customGreeting = customGreeting;
    }

    // Implementing the abstract greet method
    @Override
    public void greet(String name) {
        System.out.println(customGreeting + ", " + name + "!");
    }

    // Overriding the default sayHello method
    @Override
    public void sayHello(String name) {
        System.out.println("Greetings, " + name + "! We are delighted to have you.");
    }

    public String getCustomGreeting() {
        return customGreeting;
    }
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter a custom greeting (e.g., 'Hi', 'Welcome'): ");
        String customGreet = scanner.nextLine();

        // Create an instance of the WelcomeMessage class
        WelcomeMessage welcomer = new WelcomeMessage(customGreet);

        System.out.println("\n--- Using the greet() method ---");
        welcomer.greet(userName);

        System.out.println("\n--- Using the overridden sayHello() method  ---");
        welcomer.sayHello(userName);

        // Demonstrate calling the default method directly through the interface (if the class didn't override)
        Greeter defaultGreeter = new WelcomeMessage("Just a message");
        System.out.println("\n--- Using the default sayHello() method through interface reference (if not overridden - but it is) ---");
        defaultGreeter.sayHello("Guest"); // This will call the overridden method in WelcomeMessage

        System.out.println("\n--- Showing the custom greeting stored in the class ---");
        System.out.println("Custom greeting: " + welcomer.getCustomGreeting());

        scanner.close();
    }
}