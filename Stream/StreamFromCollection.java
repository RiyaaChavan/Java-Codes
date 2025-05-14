// Stream from Collection
// Convert a list of integers to stream and print all elements.

import java.util.*;
import java.util.stream.*;

public class StreamFromCollection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the list
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter " + n + " integer(s):");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        // Convert list to stream and print elements
        System.out.println("\nStream output:");
        numbers.stream().forEach(System.out::println);

        scanner.close();
    }
}
