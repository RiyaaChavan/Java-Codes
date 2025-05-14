// Use Reduce for Sum
// Use reduce() to calculate the sum of a list of integers.

import java.util.*;
import java.util.stream.*;

public class ReduceForSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the list of integers
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter " + n + " integer(s):");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        // Using reduce to calculate the sum
        int sum = numbers.stream().reduce(0, Integer::sum);

        System.out.println("\nSum of all integers using reduce(): " + sum);

        scanner.close();
    }
}
