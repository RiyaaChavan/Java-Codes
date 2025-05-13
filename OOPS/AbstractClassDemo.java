//q:Create an abstract class with a constructor and extend it in a subclass with additional logic.

import java.util.Scanner;

// Abstract class with a constructor
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
        System.out.println("Shape constructor called for: " + name);
    }

    // Abstract method to calculate area (to be implemented by subclasses)
    public abstract double calculateArea();

    // Concrete method that can be inherited
    public void display() {
        System.out.println("This is a shape named: " + name);
    }
}

// Subclass extending the abstract class
class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name); // Call the constructor of the superclass (Shape)
        this.radius = radius;
        System.out.println("Circle constructor called with radius: " + radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the circle: ");
        String circleName = scanner.nextLine();

        System.out.print("Enter the radius of the circle: ");
        double circleRadius = scanner.nextDouble();

        // Create an instance of the Circle subclass
        Circle myCircle = new Circle(circleName, circleRadius);

        // Call methods on the Circle object
        myCircle.display();
        System.out.println("Area of the " + myCircle.name + " is: " + String.format("%.2f", myCircle.calculateArea()));
        System.out.println("Radius of the " + myCircle.name + " is: " + myCircle.getRadius());

        scanner.close();
    }
}