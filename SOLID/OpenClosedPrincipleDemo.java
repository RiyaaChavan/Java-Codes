package MongoDB.SOLID;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Step 1: Create an interface for the base functionality
interface Shape {
    double area();
    String getName();
}

// Step 2: Implement the interface with a concrete class
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
    
    public String getName() {
        return "Rectangle";
    }
}

// Step 3: Implement the interface with another concrete class
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
    
    public String getName() {
        return "Circle";
    }
}

// Step 4: Create a new class that extends the base functionality (without modifying existing classes)
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }
    
    public String getName() {
        return "Triangle";
    }
}

// Step 5: Create a class that uses the interface
class AreaCalculator {
    public double calculateArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }
}

// Main class to demonstrate the Open/Closed Principle
public class OpenClosedPrincipleDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();
        
        boolean addMoreShapes = true;
        
        while (addMoreShapes) {
            System.out.println("\n=== Shape Creator Menu ===");
            System.out.println("1. Add Rectangle");
            System.out.println("2. Add Circle");
            System.out.println("3. Add Triangle");
            System.out.println("4. Calculate Total Area");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch (choice) {
                case 1: // Add Rectangle
                    try {
                        System.out.print("Enter width: ");
                        double width = Double.parseDouble(scanner.nextLine());
                        
                        System.out.print("Enter height: ");
                        double height = Double.parseDouble(scanner.nextLine());
                        
                        shapes.add(new Rectangle(width, height));
                        System.out.println("Rectangle added successfully!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid numbers.");
                    }
                    break;
                    
                case 2: // Add Circle
                    try {
                        System.out.print("Enter radius: ");
                        double radius = Double.parseDouble(scanner.nextLine());
                        
                        shapes.add(new Circle(radius));
                        System.out.println("Circle added successfully!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    break;
                    
                case 3: // Add Triangle
                    try {
                        System.out.print("Enter base: ");
                        double base = Double.parseDouble(scanner.nextLine());
                        
                        System.out.print("Enter height: ");
                        double triangleHeight = Double.parseDouble(scanner.nextLine());
                        
                        shapes.add(new Triangle(base, triangleHeight));
                        System.out.println("Triangle added successfully!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid numbers.");
                    }
                    break;
                    
                case 4: // Calculate Total Area
                    AreaCalculator calculator = new AreaCalculator();
                    double totalArea = calculator.calculateArea(shapes);
                    
                    System.out.println("\n--- Shapes in the List ---");
                    for (Shape shape : shapes) {
                        System.out.println(shape.getName() + " with area: " + shape.area());
                    }
                    
                    System.out.println("\nTotal Area of All Shapes: " + totalArea);
                    break;
                    
                case 5: // Exit
                    addMoreShapes = false;
                    System.out.println("Exiting program. Thank you!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}