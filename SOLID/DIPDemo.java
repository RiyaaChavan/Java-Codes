//q:Apply Dependency Inversion Principle
//Demonstrate loose coupling by injecting service objects through constructors or interfaces.

package MongoDB.SOLID;

import java.util.Scanner;

// Service Interface
interface MessageService {
    void sendMessage(String message, String recipient);
}

// Concrete Service 1: Email Service
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

// Concrete Service 2: SMS Service
class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

// Client Class depending on abstraction
class NotificationService {
    private MessageService messageService;

    // Constructor Injection
    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}

// Main class to demonstrate Dependency Inversion Principle
public class DIPDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a message service: ");
        System.out.println("1. Email Service");
        System.out.println("2. SMS Service");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        MessageService service = null;
        if (choice == 1) {
            service = new EmailService();
        } else if (choice == 2) {
            service = new SMSService();
        } else {
            System.out.println("Invalid choice. Exiting.");
            scanner.close();
            return;
        }

        System.out.print("Enter the message: ");
        String message = scanner.nextLine();
        System.out.print("Enter the recipient: ");
        String recipient = scanner.nextLine();

        NotificationService notificationService = new NotificationService(service);
        notificationService.sendNotification(message, recipient);

        scanner.close();
    }
}
