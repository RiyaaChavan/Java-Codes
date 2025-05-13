//q:Demonstrate how different implementations of an interface can be used interchangeably polymorphically.

import java.util.Scanner;

// Interface defining a common behavior
interface Shape {
    double calculateArea();
    void display();
}

// First implementation of the Shape interface: Circle
class Circle implements Shape {
    private double radius;
    private String name;

    public Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Shape: " + name + " (Circle), Radius: " + String.format("%.2f", radius) + ", Area: " + String.format("%.2f", calculateArea()));
    }
}

// Second implementation of the Shape interface: Rectangle
class Rectangle implements Shape {
    private double length;
    private double width;
    private String name;

    public Rectangle(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void display() {
        System.out.println("Shape: " + name + " (Rectangle), Length: " + String.format("%.2f", length) + ", Width: " + String.format("%.2f", width) + ", Area: " + String.format("%.2f", calculateArea()));
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape[] shapes = new Shape[2]; // Array to hold different Shape objects

        // Get input for the Circle
        System.out.println("--- Circle ---");
        System.out.print("Enter the name of the circle: ");
        String circleName = scanner.nextLine();
        System.out.print("Enter the radius of the circle: ");
        double circleRadius = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character left by nextDouble()
        shapes[0] = new Circle(circleName, circleRadius);

        // Get input for the Rectangle
        System.out.println("\n--- Rectangle ---");
        System.out.print("Enter the name of the rectangle: ");
        String rectangleName = scanner.nextLine();
        System.out.print("Enter the length of the rectangle: ");
        double rectangleLength = scanner.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double rectangleWidth = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        shapes[1] = new Rectangle(rectangleName, rectangleLength, rectangleWidth);

        System.out.println("\n--- Displaying Shapes ---");
        // Iterate through the array of Shape objects
        for (Shape shape : shapes) {
            shape.display(); // Polymorphic call: The correct display() method for each object is executed
            //System.out.println("Area: " + String.format("%.2f", shape.calculateArea())); // Polymorphic call for area calculation
            System.out.println("----------------------");
        }

        scanner.close();
    }
}


