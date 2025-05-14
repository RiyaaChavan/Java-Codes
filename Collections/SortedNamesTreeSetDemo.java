// Q: Sort Data using TreeSet
// Insert names in TreeSet and show sorted order output.

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortedNamesTreeSetDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> sortedNames = new TreeSet<>();

        System.out.print("Enter number of names: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter names:");
        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            sortedNames.add(name); // TreeSet maintains sorted order
        }

        System.out.println("\nSorted Unique Names:");
        for (String name : sortedNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
