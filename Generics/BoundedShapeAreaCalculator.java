// Question:
// Demonstrate Bounded Parameters with Shapes:
// Write a generic method that accepts any type that extends the Shape class (which you will define).
// The method should calculate the total area of all shapes passed in as a list.

import java.util.*;

abstract class Shape {
    public abstract double getArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}

public class BoundedShapeAreaCalculator {

    public static <T extends Shape> double calculateTotalArea(List<T> shapes) {
        double total = 0;
        for (T shape : shapes) {
            total += shape.getArea();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        double radius = scanner.nextDouble();
        shapes.add(new Circle(radius));

        System.out.print("Enter length and width of rectangle: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        shapes.add(new Rectangle(length, width));

        double totalArea = calculateTotalArea(shapes);
        System.out.printf("Total area of all shapes: %.2f\n", totalArea);

        scanner.close();
    }
}
