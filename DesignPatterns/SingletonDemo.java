package MongoDB.DesignPatterns;
//q:Write a Java class that ensures only one instance is created. Show how to access this instance from multiple points.

import java.util.Scanner;

// Singleton class
class Singleton {
    private static Singleton instance; // Private static instance variable
    private String data; // Added data member

    // Private constructor to prevent external instantiation
    private Singleton(String initialData) {
        this.data = initialData;
        System.out.println("Singleton instance created with data: " + data);
    }

    // Public static method to get the single instance
    public static Singleton getInstance(String initialData) {
        if (instance == null) {
            synchronized (Singleton.class) { // Thread-safe instantiation
                if (instance == null) {
                    instance = new Singleton(initialData);
                }
            }
        }
        return instance;
    }

    // Public method to access data
    public String getData() {
        return data;
    }

    // Public method to set data
    public void setData(String newData) {
        this.data = newData;
    }
}

// Main class to demonstrate Singleton usage
public class SingletonDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial data for the Singleton: ");
        String initialData = scanner.nextLine();

        // Get the single instance from different points
        Singleton instance1 = Singleton.getInstance(initialData);
        Singleton instance2 = Singleton.getInstance(initialData); //tries to create another instance but will get the same

        // Display that both variables point to the same instance
        System.out.println("\n--- Singleton Instances ---");
        System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);

        // Access and modify data through the Singleton instance
        System.out.println("\n--- Accessing and Modifying Data ---");
        System.out.println("Initial data from instance1: " + instance1.getData());

        System.out.print("Enter new data for the Singleton: ");
        String newData = scanner.nextLine();
        instance2.setData(newData); // Modifying using instance2

        System.out.println("Data from instance1 after modification: " + instance1.getData()); // Data is the same

        scanner.close();
    }
}
