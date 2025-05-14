// Q: LinkedHashMap for Recent Activities
// Record user activity timestamps while maintaining insertion order.

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RecentActivitiesLinkedHashMapDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> activityLog = new LinkedHashMap<>();

        System.out.print("Enter number of activities: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("\nEnter activity name: ");
            String activity = scanner.nextLine();

            String timestamp = java.time.LocalDateTime.now().toString();
            activityLog.put(activity, timestamp);

            // Simulate delay for different timestamps (optional)
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }

        System.out.println("\nRecent Activities (in order):");
        for (Map.Entry<String, String> entry : activityLog.entrySet()) {
            System.out.println("Activity: " + entry.getKey() + ", Timestamp: " + entry.getValue());
        }

        scanner.close();
    }
}
