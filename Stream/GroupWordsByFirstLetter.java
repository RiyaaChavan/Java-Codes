package MongoDB.Stream;
// Question:
// Group Words by First Letter into a Map
// Write a program that uses streams to group words from an array by their first letter into a map 
// where keys are letters and values are lists of words starting with those letters. 
// Extend this to sort the words within each list alphabetically.

import java.util.*;
import java.util.stream.Collectors;

public class GroupWordsByFirstLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] words = new String[n];
        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine().trim();
        }

        Map<Character, List<String>> groupedMap = Arrays.stream(words)
                .filter(w -> !w.isEmpty())
                .collect(Collectors.groupingBy(
                        word -> Character.toUpperCase(word.charAt(0)),
                        TreeMap::new, // Use TreeMap for sorted keys
                        Collectors.mapping(
                                String::toLowerCase,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            list.sort(String::compareTo);
                                            return list;
                                        }
                                )
                        )
                ));

        // Print the grouped and sorted map
        System.out.println("\nGrouped words by first letter (sorted):");
        groupedMap.forEach((ch, list) -> {
            System.out.println(ch + ": " + list);
        });

        scanner.close();
    }
}
