// Map and Filter Stream Operations
// Given a list of names, filter names starting with 'A' and convert them to uppercase.

import java.util.*;
import java.util.stream.*;

public class MapFilterStreamOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the list of names
        System.out.print("Enter the number of names: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<String> names = new ArrayList<>();
        System.out.println("Enter " + n + " name(s):");
        for (int i = 0; i < n; i++) {
            names.add(scanner.nextLine());
        }

        // Filter names starting with 'A' and convert them to uppercase
        System.out.println("\nFiltered and Uppercased Names (starting with 'A'):");
        names.stream()
             .filter(name -> name.startsWith("A") || name.startsWith("a"))
             .map(String::toUpperCase)
             .forEach(System.out::println);

        scanner.close();
    }
}
