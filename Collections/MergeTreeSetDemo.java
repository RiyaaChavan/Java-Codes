// Question:
// Merge Two TreeSets of Integers:
// Implement a method that takes two TreeSet<Integer> objects as parameters, merges them into one, and returns the merged set without duplicates.
// Demonstrate this with sample data.

import java.util.Scanner;
import java.util.TreeSet;

public class MergeTreeSetDemo {

    public static TreeSet<Integer> mergeSets(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> merged = new TreeSet<>(set1);
        merged.addAll(set2); // Automatically removes duplicates due to TreeSet properties
        return merged;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();

        System.out.print("Enter number of elements in first TreeSet: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter elements for first TreeSet:");
        for (int i = 0; i < n1; i++) {
            set1.add(scanner.nextInt());
        }

        System.out.print("Enter number of elements in second TreeSet: ");
        int n2 = scanner.nextInt();
        System.out.println("Enter elements for second TreeSet:");
        for (int i = 0; i < n2; i++) {
            set2.add(scanner.nextInt());
        }

        TreeSet<Integer> mergedSet = mergeSets(set1, set2);

        System.out.println("Merged TreeSet (sorted and unique): " + mergedSet);

        scanner.close();
    }
}
