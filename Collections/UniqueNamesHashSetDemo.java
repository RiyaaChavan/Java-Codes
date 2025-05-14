// Q: Remove Duplicates using HashSet
// Input a list of names and store unique ones using HashSet.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNamesHashSetDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> uniqueNames = new HashSet<>();

        System.out.print("Enter number of names: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter names:");
        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            uniqueNames.add(name); // HashSet automatically avoids duplicates
        }

        System.out.println("\nUnique Names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
