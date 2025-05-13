//q:Create a program showing key differences in features and usage of both.

import java.util.Scanner;

// Interface defining a contract for greeting
interface Greeting {
    String greet(String name); // Abstract method

    default void welcomeMessage(String name) { // Default method
        System.out.println("Welcome, " + name + "!");
    }
}

// Abstract class representing a basic shape
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
        System.out.println("Shape constructor called for: " + name);
    }

    public String getName() {
        return name;
    }

    public abstract double calculateArea(); // Abstract method

    public void displayCommon() { // Concrete method
        System.out.println("This is a shape named: " + name);
    }
}

// Class implementing the Greeting interface
class Salutation implements Greeting {
    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}

// Class extending the Shape abstract class
class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}

public class AbstractInterfaceComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Using Interface (Greeting) ---");
        Salutation salutation = new Salutation();
        System.out.print("Enter name for greeting: ");
        String greetName = scanner.nextLine();
        System.out.println(salutation.greet(greetName));
        salutation.welcomeMessage(greetName);

        System.out.println("\n--- Using Abstract Class (Shape) and Subclass (Circle) ---");
        System.out.print("Enter name for circle: ");
        String circleName = scanner.nextLine();
        System.out.print("Enter radius for circle: ");
        double circleRadius = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Circle circle = new Circle(circleName, circleRadius);
        circle.displayCommon();
        System.out.println("Area of " + circle.getName() + " is: " + String.format("%.2f", circle.calculateArea()));
        System.out.println("Radius of " + circle.getName() + " is: " + circle.getRadius());

        System.out.println("\n--- Key Differences Illustrated ---");
        System.out.println("1. Inheritance: A class can implement multiple interfaces but can extend only one abstract class.");
        System.out.println("2. Constructors: Abstract classes can have constructors (Shape has one), interfaces cannot.");
        System.out.println("3. Method Implementation: Interfaces (before Java 8) could only have abstract methods. Now they can have default and static methods. Abstract classes can have abstract and concrete methods.");
        System.out.println("4. State (Instance Variables): Abstract classes can have instance variables (like 'name' and 'radius' in Shape and Circle). Interfaces cannot have instance variables (only constants - public static final).");
        System.out.println("5. Purpose: Interfaces define a contract of what a class should do. Abstract classes provide a common base class with partial implementation, focusing on what a class is.");

        scanner.close();
    }
}