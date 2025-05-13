package MongoDB.SOLID;

// Q: Apply Liskov Substitution Principle
// Show how a subclass (e.g., Square) can be substituted for a superclass (e.g., Rectangle) without altering behavior.

import java.util.Scanner;

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}

public class LiskovSubstitutionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangle rectangle = new Rectangle();
        Square square = new Square();

        System.out.println("Enter width and height for Rectangle:");
        System.out.print("Width: ");
        int rectWidth = scanner.nextInt();
        System.out.print("Height: ");
        int rectHeight = scanner.nextInt();

        rectangle.setWidth(rectWidth);
        rectangle.setHeight(rectHeight);
        System.out.println("Rectangle Area: " + rectangle.getArea());

        System.out.println("\nEnter side length for Square:");
        int side = scanner.nextInt();

        square.setWidth(side); // or setHeight(side)
        System.out.println("Square Area (using LSP): " + square.getArea());

        scanner.close();
    }
}
