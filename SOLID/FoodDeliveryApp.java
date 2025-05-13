// Question: Implement SOLID Principle to design the application
// Design a food delivery application where users can create and view orders. 
// Later, stakeholders requested to:
// 1. Implement sending orders via email.
// 2. Display the order total price in the email.
// 3. Update our order view.
// SOLID principles are used to extend and modify the application without changing the original functionalities.

package MongoDB.SOLID;
import java.util.*;

// Order class (Single Responsibility Principle)
class Order {
    private List<String> items;
    private double totalPrice;

    public Order(List<String> items) {
        this.items = items;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        return items.size() * 10;  // Simple price logic for the sake of example.
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<String> getItems() {
        return items;
    }
}

// OrderService class (Handles order creation and viewing)
class OrderService {
    public Order createOrder(List<String> items) {
        return new Order(items);
    }

    public void viewOrder(Order order) {
        System.out.println("Order Details: " + order.getItems() + " | Total Price: $" + order.getTotalPrice());
    }
}

// EmailService interface (Interface Segregation Principle)
interface EmailService {
    void sendOrderEmail(Order order);
}

// EmailOrderService class (Handles sending emails)
class EmailOrderService implements EmailService {
    @Override
    public void sendOrderEmail(Order order) {
        System.out.println("Sending email for order: " + order.getItems());
        System.out.println("Total Price in email: $" + order.getTotalPrice());
    }
}

// OrderView interface (Interface Segregation Principle)
interface OrderView {
    void displayOrder(Order order);
}

// SimpleOrderView class (Basic view for order)
class SimpleOrderView implements OrderView {
    @Override
    public void displayOrder(Order order) {
        System.out.println("Simple Order View: " + order.getItems() + " | Total: $" + order.getTotalPrice());
    }
}

// UpdatedOrderView class (Extended view with a message)
class UpdatedOrderView implements OrderView {
    @Override
    public void displayOrder(Order order) {
        System.out.println("Updated Order View: " + order.getItems() + " | Total Price: $" + order.getTotalPrice());
        System.out.println("Thank you for ordering! Your order will be processed soon.");
    }
}

// Main Application Class
public class FoodDeliveryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some orders
        System.out.println("Enter the number of items for the order: ");
        int numItems = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        List<String> items = new ArrayList<>();
        System.out.println("Enter the items for the order: ");
        for (int i = 0; i < numItems; i++) {
            items.add(scanner.nextLine());
        }

        // Basic system (before new requirements)
        OrderService orderService = new OrderService();
        Order order = orderService.createOrder(items);
        orderService.viewOrder(order);

        // New system with added email functionality
        EmailOrderService emailOrderService = new EmailOrderService();
        emailOrderService.sendOrderEmail(order);

        // Updating order view with new feature
        OrderView updatedOrderView = new UpdatedOrderView();
        updatedOrderView.displayOrder(order);

        scanner.close();
    }
}
