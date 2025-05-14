// Bounded Generics Example
// Create a generic method to print numeric values only using bounded type parameters.

import java.util.*;

public class BoundedGenericsExample {

    // Generic method to print numeric values using bounded type parameter
    public static <T extends Number> void printNumbers(List<T> numbers) {
        for (T number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking integer input from user
        System.out.print("Enter number of integers: ");
        int intCount = scanner.nextInt();
        List<Integer> intList = new ArrayList<>();
        System.out.println("Enter " + intCount + " integer(s):");
        for (int i = 0; i < intCount; i++) {
            intList.add(scanner.nextInt());
        }

        // Taking double input from user
        System.out.print("Enter number of doubles: ");
        int doubleCount = scanner.nextInt();
        List<Double> doubleList = new ArrayList<>();
        System.out.println("Enter " + doubleCount + " double(s):");
        for (int i = 0; i < doubleCount; i++) {
            doubleList.add(scanner.nextDouble());
        }

        // Print both lists using bounded generics
        System.out.println("\nInteger values:");
        printNumbers(intList);

        System.out.println("\nDouble values:");
        printNumbers(doubleList);

        scanner.close();
    }
}
