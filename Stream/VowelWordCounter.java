// Question:
// Count Words Starting with Vowels from a File
// Write a method that reads an array of strings representing words and returns the count of words that start with vowels.

import java.util.Scanner;

public class VowelWordCounter {

    public static int countWordsStartingWithVowel(String[] words) {
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toLowerCase(word.charAt(0));
                if ("aeiou".indexOf(firstChar) != -1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] words = new String[n];
        System.out.println("Enter words (simulating file content):");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine().trim();
        }

        int vowelCount = countWordsStartingWithVowel(words);
        System.out.println("Number of words starting with a vowel: " + vowelCount);

        scanner.close();
    }
}
