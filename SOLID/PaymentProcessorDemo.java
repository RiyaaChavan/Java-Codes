// Q: Apply Open/Closed Principle
// Create a class that can be extended for new functionality without modifying the existing code.

package MongoDB.SOLID;
import java.util.Scanner;

// Step 1: Abstraction for payment methods
interface PaymentMethod {
    void pay(double amount);
}

// Step 2: Concrete implementations (extending without modifying existing code)
class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

// New payment method added without changing PaymentProcessor or existing classes
class UpiPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using UPI.");
    }
}

// Step 3: High-level class that uses PaymentMethod abstraction
class PaymentProcessor {
    private PaymentMethod method;

    public PaymentProcessor(PaymentMethod method) {
        this.method = method;
    }

    public void processPayment(double amount) {
        method.pay(amount);
    }
}

// Step 4: Demo class with user input
public class PaymentProcessorDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Choose payment method (credit/paypal/upi): ");
        String method = scanner.nextLine();

        PaymentMethod paymentMethod;

        switch (method.toLowerCase()) {
            case "credit":
                paymentMethod = new CreditCardPayment();
                break;
            case "paypal":
                paymentMethod = new PayPalPayment();
                break;
            case "upi":
                paymentMethod = new UpiPayment();
                break;
            default:
                System.out.println("Invalid payment method.");
                scanner.close();
                return;
        }

        PaymentProcessor processor = new PaymentProcessor(paymentMethod);
        processor.processPayment(amount);

        scanner.close();
    }
}
