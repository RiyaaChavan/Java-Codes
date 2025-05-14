// Question: Simulate Customer Orders with Item Categories
// Create an application that simulates customer orders, where each order has items with prices and categories (e.g., electronics, groceries). 
// Use streams to calculate total sales for each item category, displaying results in a user-friendly format.

import java.util.*;
import java.util.stream.Collectors;

class Item {
    String name;
    double price;
    String category;

    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

public class CustomerOrderSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List to store items
        List<Item> items = new ArrayList<>();

        // Get number of items
        System.out.println("Enter number of items: ");
        int numItems = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline character

        // Input items
        for (int i = 0; i < numItems; i++) {
            System.out.println("Enter name of item " + (i + 1) + ": ");
            String name = scanner.nextLine();
            
            System.out.println("Enter price of " + name + ": ");
            double price = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            
            System.out.println("Enter category of " + name + " (e.g., electronics, groceries): ");
            String category = scanner.nextLine();

            items.add(new Item(name, price, category));
        }

        // Using streams to calculate total sales for each category
        Map<String, Double> totalSalesByCategory = items.stream()
            .collect(Collectors.groupingBy(Item::getCategory, 
                    Collectors.summingDouble(Item::getPrice)));

        // Display results in a user-friendly format
        System.out.println("\nTotal Sales by Category:");
        totalSalesByCategory.forEach((category, totalSales) -> 
            System.out.println(category + ": $" + totalSales)
        );

        scanner.close();
    }
}
