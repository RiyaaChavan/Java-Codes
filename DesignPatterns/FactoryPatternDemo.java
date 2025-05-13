// q: Create a factory method that returns different types of shapes (e.g., Circle, Square) based on input
package MongoDB.DesignPatterns;
import java.util.Scanner;

// Interface for shapes
interface Shape {
    void draw();
}

// Concrete class for Circle
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }
}

// Concrete class for Square
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square with side " + side);
    }
}

// Factory class to create shapes
class ShapeFactory {
    public static Shape getShape(String shapeType, double value) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(value);
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square(value);
        }
        return null;
    }
}

// Main class to demonstrate Factory Pattern
public class FactoryPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the shape type (CIRCLE or SQUARE): ");
        String shapeType = scanner.nextLine();

        System.out.print("Enter the value (radius for circle, side for square): ");
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        // Get the shape object from the factory
        Shape shape = ShapeFactory.getShape(shapeType, value);

        // Draw the shape
        if (shape != null) {
            shape.draw();
        } else {
            System.out.println("Invalid shape type.");
        }

        scanner.close();
    }
}
