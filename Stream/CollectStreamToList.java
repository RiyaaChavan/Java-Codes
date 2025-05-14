// Collect Stream to List
// Convert a list of strings into a stream, modify, and collect it back to list.

import java.util.*;
import java.util.stream.*;

public class CollectStreamToList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the list of strings
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<String> originalList = new ArrayList<>();
        System.out.println("Enter " + n + " string(s):");
        for (int i = 0; i < n; i++) {
            originalList.add(scanner.nextLine());
        }

        // Convert to stream, modify (e.g., convert to uppercase), and collect back to list
        List<String> modifiedList = originalList.stream()
                                                .map(String::toUpperCase)
                                                .collect(Collectors.toList());

        // Display the modified list
        System.out.println("\nModified List (Uppercase Strings):");
        modifiedList.forEach(System.out::println);

        scanner.close();
    }
}
