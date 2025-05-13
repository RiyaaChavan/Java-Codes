//q: Implement two interfaces in a single class and invoke their methods. 

import java.util.Scanner;

// First Interface
interface Printable {
    void print();
}

// Second Interface
interface Calculable {
    int add(int a, int b);
}

// Class implementing both interfaces
class Calculator implements Printable, Calculable {
    private String message;

    public Calculator(String message) {
        this.message = message;
    }

    // Implementation of the print() method from the Printable interface
    @Override
    public void print() {
        System.out.println("Message to print: " + message);
    }

    // Implementation of the add() method from the Calculable interface
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    public String getMessage() {
        return message;
    }
}

public class MultipleInterfacesDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the message to be printed: ");
        String inputMessage = scanner.nextLine();

        // Create an instance of the Calculator class
        Calculator calc = new Calculator(inputMessage);

        // Invoke the print() method from the Printable interface
        calc.print();

        System.out.print("Enter the first number to add: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number to add: ");
        int num2 = scanner.nextInt();

        // Invoke the add() method from the Calculable interface
        int sum = calc.add(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

        System.out.println("The stored message in the calculator is: " + calc.getMessage());

        scanner.close();
    }
}