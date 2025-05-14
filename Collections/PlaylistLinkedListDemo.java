// Q: LinkedList Example for Playlist
// Manage songs in a playlist using LinkedList and show add/remove operations.


import java.util.LinkedList;
import java.util.Scanner;

public class PlaylistLinkedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> playlist = new LinkedList<>();
        int choice;

        do {
            System.out.println("\n=== Playlist Menu ===");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. View Playlist");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add: ");
                    String songToAdd = scanner.nextLine();
                    playlist.add(songToAdd);
                    System.out.println("Song added to playlist.");
                    break;

                case 2:
                    System.out.print("Enter song name to remove: ");
                    String songToRemove = scanner.nextLine();
                    boolean removed = playlist.remove(songToRemove);
                    if (removed) {
                        System.out.println("Song removed from playlist.");
                    } else {
                        System.out.println("Song not found in playlist.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Current Playlist ---");
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty.");
                    } else {
                        int i = 1;
                        for (String song : playlist) {
                            System.out.println(i++ + ". " + song);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting playlist manager...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
