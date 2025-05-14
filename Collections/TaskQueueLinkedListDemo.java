// Q: Implement Queue with LinkedList
// Simulate a task queue with enqueue, dequeue operations using LinkedList.

import java.util.LinkedList;
import java.util.Scanner;

public class TaskQueueLinkedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> taskQueue = new LinkedList<>();
        int choice;

        do {
            System.out.println("\n=== Task Queue Menu ===");
            System.out.println("1. Enqueue Task");
            System.out.println("2. Dequeue Task");
            System.out.println("3. View Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task to enqueue: ");
                    String task = scanner.nextLine();
                    taskQueue.addLast(task); // enqueue (add to end)
                    System.out.println("Task enqueued.");
                    break;

                case 2:
                    if (!taskQueue.isEmpty()) {
                        String removedTask = taskQueue.removeFirst(); // dequeue (remove from front)
                        System.out.println("Dequeued Task: " + removedTask);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 3:
                    System.out.println("\nCurrent Task Queue:");
                    if (taskQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        for (String t : taskQueue) {
                            System.out.println("- " + t);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Task Queue.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
